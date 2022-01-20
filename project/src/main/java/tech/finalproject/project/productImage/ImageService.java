package tech.finalproject.project.productImage;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void saveImage(MultipartFile imageFile)  throws Exception
    {
        String folder = "D://photos/";
        byte[] bytes = imageFile.getBytes();
       Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path,bytes);
    }


}
