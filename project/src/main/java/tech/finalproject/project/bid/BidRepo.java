package tech.finalproject.project.bid;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.bid.BidModel;

import java.util.List;

public interface BidRepo extends JpaRepository<BidModel, Long> {
//
//    Page<BidModel> findByProductName(String productName);
//    List<BidModel> findAllByOrderByCreateDateAsc();
}
