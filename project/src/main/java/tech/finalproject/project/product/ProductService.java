package tech.finalproject.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tech.finalproject.project.productImage.Image;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }


    public ProductDetails addProduct(ProductDetails productDetails)
    {

        return productRepo.save(productDetails);
    }

//    public String findProductName(String productName)
//    {
//        return productRepo.findProductName(productName);
//    }


    public List<ProductDetails> findallProducts()
    {

        return productRepo.findAll();
    }

    public ProductDetails updateProduct(ProductDetails productDetails)
    {

        return productRepo.save(productDetails);
    }

    public ProductDetails findProductById(Long id)
    {
        return productRepo.findProductById(id).
                orElseThrow(()-> new ProductNotFoundException("Product by id" + id + "was nto found"));
    }

    public void deleteProduct(Long id)
    {

        productRepo.deleteProductById(id);
    }

    public void saveImage(MultipartFile imageFile) {
    }
}