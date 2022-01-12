//package tech.finalproject.project.product;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import tech.finalproject.project.product.ProductDetails;
//
//import java.util.Optional;
//
//public interface ProductRepo extends JpaRepository<ProductDetails, Long> {
//
//    Optional<ProductDetails> findProductById(Long id);
//
//    void deleteProductById(Long id);
//}

package tech.finalproject.project.product;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.product.ProductDetails;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductDetails, Long>{

    Optional<ProductDetails> findProductById(Long id);

    void deleteProductById(Long id);
}
