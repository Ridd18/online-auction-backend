package tech.finalproject.project.bid;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.bid.BidModel;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import java.util.List;
import java.util.Optional;

public interface BidRepo extends JpaRepository<BidModel, Long> {
//

//    List<BidModel> findAllByOrderByCreateDateAsc();


    List<BidModel> findByProductName(String productName);

}
