package tech.finalproject.project.bid;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.product.ProductDetails;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BidController {


    private final BidService  bidService;

    public BidController(BidService bidService) {

        this.bidService = bidService;
    }

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public BidResponse getBidder(BidModel bidModel)
    {
        return new BidResponse("hie"+bidModel.getBidderName(),bidModel.getBidAmount(),bidModel.getProductName(),bidModel.getEndDate());
    }


    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public String chat(String msg) {
        System.out.println(msg);
        return msg;
    }

    @GetMapping("/auction/bid/all")
    public ResponseEntity<List<BidModel>> getAllBids()
    {
        List<BidModel> bids = bidService.findAllBids();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }


    @GetMapping("/auction/bid/find/{productName}")
    public ResponseEntity<List<BidModel>> getBidsByProductName(@PathVariable("productName") String productName)
    {
        List<BidModel> bid = bidService.findByProductName(productName);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }

    @GetMapping("/auction/bid/findByProductId/{productId}")
    public ResponseEntity<List<BidModel>> getBidsByProductId(@PathVariable("product_id") Long productId)
    {
        List<BidModel> bid = bidService.findByProductId(productId);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }

    @PostMapping("/auction/bid/add")
    public ResponseEntity<BidModel> addBid(@RequestBody BidModel bidModel)
    {
        BidModel newBid = bidService.addBid(bidModel);
        return new ResponseEntity<>(newBid, HttpStatus.CREATED);
    }



    @GetMapping("/auction/bid/sell/{productId}")
    public ResponseEntity<BidModel> sellProduct(@PathVariable("productId") Long productId) {


        BidModel lastBid = bidService.findBidByProductId(productId);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = lastBid.getEndDate();
        String EndDate = simpleDateFormat1.format(endDate);
        System.out.println("Product End Date "+ EndDate );


        Long currentTimeInSeconds = System.currentTimeMillis();
        System.out.println("SECONDS of Today's Date "+ currentTimeInSeconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(currentTimeInSeconds);

        String CurrentDate = simpleDateFormat.format(currentDate);
        System.out.println("Today's Date "+ CurrentDate);


        if (endDate == null)
        {
            System.out.println(" date not found" );
        }

        if(EndDate.equals(CurrentDate))
        {
                System.out.println("Same date");
                System.out.println("max bid "+ lastBid.getBidAmount() );
            return new ResponseEntity<>(lastBid, HttpStatus.OK);
        }
        else
        {
            System.out.println("no same date");

        }

        return new ResponseEntity<>(lastBid, HttpStatus.OK);

    }


    @PostMapping("/auction/bid/sells/{productId}")
    public BidModel sellProducts(@PathVariable("productId") Long productId)
    {
//        Long productId = bid.getProductId();

        BidModel bidder = null;
        if(productId != null)
        {
            BidModel lastBid = bidService.findBidByProductId(productId);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date endDate = lastBid.getEndDate();
            String EndDate = simpleDateFormat1.format(endDate);
            System.out.println("Product End Date "+ EndDate );


            Long currentTimeInSeconds = System.currentTimeMillis();
            System.out.println("SECONDS of Today's Date "+ currentTimeInSeconds);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date(currentTimeInSeconds);

            String CurrentDate = simpleDateFormat.format(currentDate);
            System.out.println("Today's Date "+ CurrentDate);


            if(EndDate.equals(CurrentDate))
            {
                System.out.println("Same date");
                System.out.println("max bid "+ lastBid.getBidAmount() );
                return lastBid;
            }
            else
            {
                System.out.println("no same date");

            }
        }

        return bidder;

    }

}
