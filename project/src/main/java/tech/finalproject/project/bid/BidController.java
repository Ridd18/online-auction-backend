package tech.finalproject.project.bid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;





import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class BidController {

    @Autowired
    private BidRepo bidRepo;


//    @Autowired
//    private SimpMessagingTemplate template;

    @MessageMapping("/bid.register")
    @SendTo("/auction/addBid/public")
    public BidModel register(@Payload BidModel bidModel , SimpMessageHeaderAccessor headerAccessor)
    {
        headerAccessor.getSessionAttributes().put("bidderName", bidModel.getBidderName());
        return bidModel;
    }


    @MessageMapping("/bid.send")
    @SendTo("/auction/addBid/public")
    public BidModel sendBid(@Payload BidModel bidModel)
    {
        return bidModel;
    }

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
