package tech.finalproject.project.buyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import java.util.Optional;


public interface BuyerRepo extends JpaRepository<BuyerLoginDetails, Long> {


    public BuyerLoginDetails findByUsernameAndPassword(String username, String password);

    public BuyerLoginDetails findByEmailAndPassword(String email , String password);

    void deleteBuyerById(Long id);

//    public BuyerLoginDetails findByUsername(String username);

    Optional<BuyerLoginDetails> findBuyerById(Long id);

    Optional<BuyerLoginDetails> findByEmail(String email);

    Optional<BuyerLoginDetails> findByUsername(String username);
}


//
//package tech.finalproject.project.buyer;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import tech.finalproject.project.buyer.BuyerLoginDetails;
//
//import java.util.Optional;
//
//public interface BuyerRepo{
//    public boolean addBuyer(BuyerRepo buyer);
//    public boolean delete(BuyerRepo buyer);
//
//    public boolean getBuyers(BuyerRepo buyer);
//}
