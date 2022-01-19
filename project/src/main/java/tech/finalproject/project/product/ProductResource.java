package tech.finalproject.project.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.productImage.Image;

import javax.imageio.IIOException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auction")
public class ProductResource {


    @Autowired
    private ProductRepo productRepo;



    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDetails>> getAllProducts()
    {
        List<ProductDetails> product = productService.findallProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/find/{id}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable("id") Long id)
    {
        ProductDetails product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/product/add")
    public ResponseEntity<ProductDetails> addProduct(@RequestBody ProductDetails productDetails)
    {

            ProductDetails product = new ProductDetails();

            product.setProductImageName(productDetails.getProductName());
            product.setProductName(productDetails.getProductName());
            product.setCategoryName(productDetails.getCategoryName());
            product.setProductDescription(productDetails.getProductDescription());
            product.setStartDate(productDetails.getStartDate());
            product.setEndDate(productDetails.getEndDate());
            product.setStartBid(productDetails.getStartBid());

//            product =  productService.addProduct(productDetails);

            final ProductDetails newProduct = productRepo.save(product);

//            ProductDetails newProduct = productService.addProduct(productDetails);

//            newProduct.setProductImageName(productDetails.getProductName());
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
//        String returnValue = "start";
//
//
//
//        try {
//            Image image = new Image();
//            image.setName(imageFile.getOriginalFilename());
//            image.setPath("D://photos/");
//            image.setProduct(productDetails);
//            productService.saveImage(imageFile, image);
//            returnValue = "saved";
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



    @PutMapping("/product/update")
    public ResponseEntity<ProductDetails> updateProduct(@RequestBody ProductDetails productDetails)
    {
        ProductDetails updateProduct = productService.updateProduct(productDetails);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK );
    }

    @PutMapping("/product/edit/{id}")
    public ResponseEntity<ProductDetails> editProduct(@PathVariable("id") Long id,
                                                      @RequestBody ProductDetails productDetails)
    {
        ProductDetails product = productRepo.findProductById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found for this id :: " + id));

        product.setProductName(productDetails.getProductName());
        product.setCategoryName(productDetails.getCategoryName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setStartDate(productDetails.getStartDate());
        product.setEndDate(productDetails.getEndDate());
        product.setStartBid(productDetails.getStartBid());

        final ProductDetails updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @Transactional
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
