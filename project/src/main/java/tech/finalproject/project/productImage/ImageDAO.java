//package tech.finalproject.project.productImage;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import tech.finalproject.project.productImage.ImageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class ImageDAO implements iImageDAO {
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @Override
//    public void save(Image image)
//    {
//        imageRepository.save(image);
//    }
//
//    @Override
//    public void saveImage(MultipartFile imageFile) throws IOException {
//
//        String folder = "D://photos/";
//        byte[] bytes = imageFile.getBytes();
//        Path path = Paths.get(folder + imageFile.getOriginalFilename());
//        Files.write(path,bytes);
//    }
//}
