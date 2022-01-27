package tech.finalproject.project.bid;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BuyerLoginDetails;

import javax.validation.Valid;
import java.util.List;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
//@RequestMapping("/auction")
public class BidController {


    private final BidService  bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public BidResponse getBidder(BidModel bidModel)
    {
        return new BidResponse("hie"+bidModel.getBidderName(),bidModel.getBidAmount(),bidModel.getProductName(),bidModel.getStartDate());
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






//    @Autowired
//    private SimpMessagingTemplate template;

//    @MessageMapping("/bid.register")
//    @SendTo("/auction/addBid/public")
//    public BidModel register(@Payload BidModel bidModel , SimpMessageHeaderAccessor headerAccessor)
//    {
//        headerAccessor.getSessionAttributes().put("bidderName", bidModel.getBidderName());
//        return bidModel;
//    }
//
//
//    @MessageMapping("/bid.send")
//    @SendTo("/auction/addBid/public")
//    public BidModel sendBid(@Payload BidModel bidModel)
//    {
//        return bidModel;
//    }

//    @MessageMapping("/resume")
//    @SendTo("/start/initial")
//    public String chat(String msg) {
//        System.out.println(msg);
//        return msg;
//    }

//    @MessageMapping("/messages")
//    public void handleMessage(BidModel bidModel) {
//        bidModel.setStartDate(new Date());
//        bidRepo.save(bidModel);
//        template.convertAndSend("/channel/chat/" + bidModel.getBidAmount(), bidModel);
//    }
}
