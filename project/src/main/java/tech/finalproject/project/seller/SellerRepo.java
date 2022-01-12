//package tech.finalproject.project.seller;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import tech.finalproject.project.seller.SellerLoginDetails;
//
//import java.util.Optional;
//
//public interface SellerRepo extends JpaRepository<SellerLoginDetails, Long> {
//
//
//    Optional<SellerLoginDetails> findSellerById(Long id);
//
//    void deleteSellerById(Long id);
//}

package tech.finalproject.project.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.seller.SellerLoginDetails;

import java.util.Optional;

public interface SellerRepo extends JpaRepository<SellerLoginDetails, Long>{

    Optional<SellerLoginDetails> findSellerById(Long id);

    public SellerLoginDetails findByEmailAndPassword(String email , String password);

    void deleteSellerById(Long id);
}
