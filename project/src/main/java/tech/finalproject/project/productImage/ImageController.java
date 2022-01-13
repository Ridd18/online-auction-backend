package tech.finalproject.project.productImage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.productImage.Image;


@RestController
@RequestMapping("/auction")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

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
    @GetMapping(path = {"/image/all"})
    public ResponseEntity<List<Image>> getAllImage() throws IOException {

        List<Image> dbImage = imageRepository.findAll();
        return new ResponseEntity<>(dbImage, HttpStatus.OK);


    }

//    @RequestMapping(value="/image/upload", method=RequestMethod.POST)
//    public ResponseEntity<Object> addImage(@RequestParam("ProductImageFile") MultipartFile fileUpload, HttpSession session) throws IOException {
//        System.out.println("File Bytes Length: " + fileUpload.getBytes().length);
//
//        Image image = new Image();
//        UUID uuid = UUID.randomUUID();
//        image.setImageName(fileUpload.getOriginalFilename() + uuid);
//
//        try {
//            image.setImage(fileUpload.getBytes());
//
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        imageDAO.save(image);
//        System.out.println("Uploading ended");
//        return new ResponseEntity<Object>(new String("Image uploaded successfully"),HttpStatus.OK);
//
//    }

//    @RequestMapping(value="/getImage/{loginname}", method=RequestMethod.GET)
//    public @ResponseBody byte[] getProfilePicture(@PathVariable("loginname")String loginname, HttpSession session) {
//        UserDetail userDetail = (UserDetail)session.getAttribute("userDetail");
//
//        if(userDetail==null) {
//            return null;
//        }
//        else {
//            ProfilePicture profilePicture = profilePictureDAO.getProfilePicture(loginname);
//            if(profilePicture!=null) {
//                return Image.getImage();
//            }
//            else {
//                return null;
//            }
//        }
//    }
}
