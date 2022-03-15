package tech.finalproject.project.buyer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BuyerRepo extends JpaRepository<BidderModel, Long> {


    public BidderModel findByUsernameAndPassword(String username, String password);

    public BidderModel findByEmailAndPassword(String email , String password);



    void deleteBuyerById(Long id);

//    public BuyerLoginDetails findByUsername(String username);



    Optional<BidderModel> findBuyerById(Long id);

    Optional<BidderModel> findByEmail(String email);

    Optional<BidderModel> findByUsername(String username);
}
