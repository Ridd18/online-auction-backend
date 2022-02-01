package tech.finalproject.project.bid;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.finalproject.project.bid.BidModel;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BidRepo extends JpaRepository<BidModel, Long> {
//

//    List<BidModel> findAllByOrderByCreateDateAsc();


    List<BidModel> findByProductName(String productName);

//    @Query("select id from bid_model where bid_amount = (SELECT MAX(bid_amount) FROM bid_model);")
//    List<BidModel> findIdOfMaxBid(@Param("id") Long id);

    List<BidModel> findByEndDate(Date endDate);


    Optional<BidModel> findBidById(Long id);


}
