package tech.finalproject.project.productImage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
//
//    ProductDetails<Image> findByProductId(Long product_id , Pageable pageable);
}