package tech.finalproject.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }


    public ProductModel addProduct(ProductModel productModel)
    {

        return productRepo.save(productModel);
    }

//    public String findProductName(String productName)
//    {
//        return productRepo.findProductName(productName);
//    }


    public List<ProductModel> findallProducts()
    {

        return productRepo.findAll();
    }

    public ProductModel updateProduct(ProductModel productModel)
    {

        return productRepo.save(productModel);
    }

    public ProductModel findProductById(Long id)
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

    public long countProducts()
    {
        return productRepo.count();
    }

}