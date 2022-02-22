package tech.finalproject.project.productImage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tech.finalproject.project.product.ProductRepo;
import tech.finalproject.project.product.ProductService;


@RestController
@RequestMapping("/auction")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductService productService;


    @PostMapping("/image/upload")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {



        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Image getImageDetails(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    @GetMapping(path = {"/image/{name}"} , produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }


    @GetMapping(path = {"/image/all"} )
    public ResponseEntity<List<Image>> getAllImage() throws IOException {

        List<Image> dbImage = imageRepository.findAll();
        return new ResponseEntity<>(dbImage, HttpStatus.OK);


    }

    @PostMapping("/image/save")
    public String saveImage(@RequestParam("imageFile") MultipartFile imageFile , Model model) throws Exception {
        String returnValue = "start";
        imageService.saveImage(imageFile);
        returnValue = "saved";
        return returnValue;
    }


    @GetMapping(value = "/image/get", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {



        var imgFile = new ClassPathResource("D://photos/");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }


}
