package tech.finalproject.project.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.bid.BidModel;
import tech.finalproject.project.bid.BidService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auction")
public class ProductResource {


    @Autowired
    private ProductRepo productRepo;

    private final BidService bidService;


    private final ProductService productService;

    public ProductResource(BidService bidService, ProductService productService) {
        this.bidService = bidService;
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
        BidModel maxBid = bidService.findBidByProductId(id);



        ProductDetails product = productService.findProductById(id);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = product.getEndDate();
        Long endSecs = endDate.getTime();
        System.out.println("SECONDS of Product's endDate "+ endSecs);
        String EndDate = simpleDateFormat1.format(endDate);
        System.out.println("Product End Date "+ EndDate );


        Long currentTimeInSeconds = System.currentTimeMillis();
        System.out.println("SECONDS of Today's Date "+ currentTimeInSeconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(currentTimeInSeconds);

        String CurrentDate = simpleDateFormat.format(currentDate);
        System.out.println("Today's Date "+ CurrentDate);

        if( endSecs < currentTimeInSeconds )
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }


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


            final ProductDetails newProduct = productRepo.save(product);

            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    @PutMapping("/product/update")
    public ResponseEntity<ProductDetails> updateProduct(@RequestBody ProductDetails productDetails)
    {
//        ProductDetails updateProduct = productService.updateProduct(productDetails);
//        return new ResponseEntity<>(updateProduct, HttpStatus.OK );

//
//        ProductDetails product = new ProductDetails();

        productDetails.setProductImageName(productDetails.getProductName());
        productDetails.setProductName(productDetails.getProductName());
        productDetails.setCategoryName(productDetails.getCategoryName());
        productDetails.setProductDescription(productDetails.getProductDescription());
        productDetails.setStartDate(productDetails.getStartDate());
        productDetails.setEndDate(productDetails.getEndDate());
        productDetails.setStartBid(productDetails.getStartBid());



        final ProductDetails updatedProduct = productRepo.save(productDetails);

        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
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
