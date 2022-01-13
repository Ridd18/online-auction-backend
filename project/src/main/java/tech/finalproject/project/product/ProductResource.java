package tech.finalproject.project.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class ProductResource {

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

    @PostMapping("/product/add")
    public ResponseEntity<ProductDetails> addProduct(@RequestBody ProductDetails productDetails)
    {
        ProductDetails newProduct = productService.addProduct(productDetails);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    //    @PostMapping("/product/save")
//    public void saveProduct(@RequestParam("productImage") MultipartFile productImage,
//                              @RequestParam("productName") String productName,
//                              @RequestParam("categoryName") String categoryName,
//                              @RequestParam("productDescription") String productDescription,
//                              @RequestParam("startDate") Date startDate,
//                              @RequestParam("endDate") Date endDate,
//                              @RequestParam("startBid") Long startBid) throws IOException {
//         productService.saveProduct(productImage,productName,categoryName,productDescription,startDate,endDate,startBid);
//
//    }

    @PutMapping("/product/update")
    public ResponseEntity<ProductDetails> updateProduct(@RequestBody ProductDetails productDetails)
    {
        ProductDetails updateProduct = productService.updateProduct(productDetails);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK );
    }

    @Transactional
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
