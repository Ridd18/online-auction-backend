package tech.finalproject.project.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.buyer.BuyerNotFoundException;
import tech.finalproject.project.product.ProductDetails;
import tech.finalproject.project.product.ProductNotFoundException;

import java.util.Date;
import java.util.List;

@Service
public class BidService {

    @Autowired
    private final BidRepo bidRepo;

    public BidService(BidRepo bidRepo) {
        this.bidRepo = bidRepo;
    }

    public BidModel addBid(BidModel bidModel)
    {

        return bidRepo.save(bidModel);
    }



    public List<BidModel> findAllBids()
    {

        return bidRepo.findAll();
    }


    public List<BidModel> findByProductName(String productName)
    {

        return bidRepo.findByProductName(productName);
    }


    public List<BidModel> findByEndDate(Date endDate)
    {
        return bidRepo.findByEndDate(endDate);

    }

    public List<BidModel> findByProductId(Long product_id)
    {

      return bidRepo.findByProductId(product_id);

    }


    public BidModel findBidById(Long id)
    {
        return bidRepo.findBidById(id).
                orElseThrow(()-> new BuyerNotFoundException("Buyer by id" + id + "was not found"));
    }

    public BidModel findBidByProductId(Long productId)
    {
        return bidRepo.findBidByProductId(productId);
    }
}
