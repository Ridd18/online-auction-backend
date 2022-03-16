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
    public ResponseEntity<List<ProductModel>> getAllProducts()
    {
        List<ProductModel> product = productService.findallProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/find/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Long id)
    {
        BidModel maxBid = bidService.findBidByProductId(id);

        ProductModel product = productService.findProductById(id);

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
            System.out.println(maxBid);
            System.out.println(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }


    }

    @PostMapping(value = "/product/add")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel)
    {

            ProductModel product = new ProductModel();

            product.setProductImageName(productModel.getProductName());
            product.setProductName(productModel.getProductName());
            product.setCategoryName(productModel.getCategoryName());
            product.setProductDescription(productModel.getProductDescription());
            product.setStartDate(productModel.getStartDate());
            product.setEndDate(productModel.getEndDate());
            product.setStartBid(productModel.getStartBid());


            final ProductModel newProduct = productRepo.save(product);

            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    @PutMapping("/product/update")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel productModel)
    {
//        ProductDetails updateProduct = productService.updateProduct(productDetails);
//        return new ResponseEntity<>(updateProduct, HttpStatus.OK );

//
//        ProductDetails product = new ProductDetails();

        productModel.setProductImageName(productModel.getProductName());
        productModel.setProductName(productModel.getProductName());
        productModel.setCategoryName(productModel.getCategoryName());
        productModel.setProductDescription(productModel.getProductDescription());
        productModel.setStartDate(productModel.getStartDate());
        productModel.setEndDate(productModel.getEndDate());
        productModel.setStartBid(productModel.getStartBid());



        final ProductModel updatedProduct = productRepo.save(productModel);

        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/product/edit/{id}")
    public ResponseEntity<ProductModel> editProduct(@PathVariable("id") Long id,
                                                    @RequestBody ProductModel productModel)
    {
        ProductModel product = productRepo.findProductById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found for this id :: " + id));

        product.setProductName(productModel.getProductName());
        product.setCategoryName(productModel.getCategoryName());
        product.setProductDescription(productModel.getProductDescription());
        product.setStartDate(productModel.getStartDate());
        product.setEndDate(productModel.getEndDate());
        product.setStartBid(productModel.getStartBid());

        final ProductModel updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @Transactional
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/product/count")
    public long countProducts()
    {
        return  productService.countProducts();
    }


}
