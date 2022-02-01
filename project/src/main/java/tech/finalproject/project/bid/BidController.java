package tech.finalproject.project.bid;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BuyerLoginDetails;

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
        List<BidModel> bids = bidService.findallBids();
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }


    @GetMapping("/auction/bid/find/{productName}")
    public ResponseEntity<List<BidModel>> getBidsByProductName(@PathVariable("productName") String productName)
    {
        List<BidModel> bid = bidService.findByProductName(productName);
        return new ResponseEntity<>(bid, HttpStatus.OK);
    }

    @PostMapping("/auction/bid/add")
    public ResponseEntity<BidModel> addBid(@RequestBody BidModel bidModel)
    {
        BidModel newBid = bidService.addBid(bidModel);
        return new ResponseEntity<>(newBid, HttpStatus.CREATED);
    }


//    @GetMapping("/auction/bid/sell/{endDate}")
//    public BidModel sellProduct(@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date date) throws Exception {
//
//        BidModel lastBid = bidService.findByEndDate(date);
//
//        Date endDate = lastBid.getEndDate();
//
//
//        BidModel bid = null;
//        if(endDate != null)
//        {
//            Date currentDate = new Date(System.currentTimeMillis());
//            System.out.println("Current Date"+  currentDate.getDate());
//            System.out.println("Current Date"+ currentDate);
//            if (endDate == currentDate)
//            {
//                return bid;
//            }
//        }
//        if (bid == null)
//        {
//            throw new Exception("BId does not exist");
//        }
//
//        return bid;
//    }



    @GetMapping("/auction/bid/sell/{id}")
    public ResponseEntity<BidModel> sellProduct(@PathVariable("id") Long id) {


        BidModel lastBid = bidService.findBidById(id);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = lastBid.getEndDate();
        System.out.println("Date "+ endDate);
        String endTime = simpleDateFormat1.format(endDate);
        System.out.println("Date "+ endTime);


        Long currentTimeinSeoonds = System.currentTimeMillis();
        System.out.println("SECONDS "+ currentTimeinSeoonds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(currentTimeinSeoonds);

        String currentTime = simpleDateFormat.format(currentDate);
        System.out.println("Date "+ currentTime);

        if(endTime.equals(currentTime))
        {
                System.out.println("Same date");
        }
        else
        {
            System.out.println("no same date");
        }
        if (endDate == null)
        {
            System.out.println(" date not found" );
        }

        return new ResponseEntity<>(lastBid, HttpStatus.OK);

    }

}
