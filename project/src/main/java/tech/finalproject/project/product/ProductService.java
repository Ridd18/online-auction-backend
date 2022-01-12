package tech.finalproject.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
