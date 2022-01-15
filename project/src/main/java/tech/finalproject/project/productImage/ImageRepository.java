package tech.finalproject.project.productImage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import tech.finalproject.project.product.ProductDetails;
import tech.finalproject.project.productImage.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
//
//    ProductDetails<Image> findByProductId(Long product_id , Pageable pageable);
}