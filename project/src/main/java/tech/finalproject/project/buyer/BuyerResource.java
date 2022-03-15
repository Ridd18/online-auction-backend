package tech.finalproject.project.buyer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/auction")
public class BuyerResource {

    private final BuyerService buyerService;

    public BuyerResource(BuyerService buyerService) {

        this.buyerService = buyerService;
    }

    @GetMapping("/buyer/all")
    public ResponseEntity<List<BidderModel>> getAllBuyers()
    {
        List<BidderModel> buyer = buyerService.findallBuyers();
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @GetMapping("/buyer/find/{id}")
    public ResponseEntity<BidderModel> getBuyerById(@PathVariable("id") Long id)
    {
        BidderModel buyer = buyerService.findBuyerById(id);
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }


    @GetMapping("/buyer/findEmail/{email}")
    public ResponseEntity<BidderModel> getBuyerByEmail(@PathVariable("email") String email)
    {
        BidderModel buyer = buyerService.findByEmail(email);
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @PostMapping("/buyer/add")
    public ResponseEntity<BidderModel> addBuyer(@Valid @RequestBody BidderModel bidderModel)
    {
//        String tempPhoneNo = newBuyer.getPhoneNo();
//        String tempEmail = newBuyer.getEmail();
//        String tempUsername= newBuyer.getUsername();
//        String tempPassword = newBuyer.getPassword();
//        BuyerLoginDetails userObj = null;
//
//        if(tempEmail != null && tempPassword != null && tempUsername != null && tempPhoneNo != null
//            && tempPassword >= )
        BidderModel newBuyer = buyerService.addBuyer(bidderModel);
        return new ResponseEntity<>(newBuyer, HttpStatus.CREATED);
    }

    @PostMapping("/buyer/login")
    public BidderModel loginUser(@RequestBody BidderModel user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        BidderModel userObj = null;
        if (tempEmail != null && tempPassword != null)
        {
            userObj = buyerService.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }

        if (userObj == null)
        {
            throw new Exception("User does not exist");
        }

        return userObj;
    }


//    public BuyerPrincipal loadEmail(@PathVariable("email") String email)
//    {
//        BuyerPrincipal user = buyerService.loadByEmail(email);
//        return new BuyerPrincipal();
//    }

    @PutMapping("/buyer/update")
    public ResponseEntity<BidderModel> updateBuyer(@RequestBody BidderModel bidderModel)
    {
        BidderModel updateBuyer = buyerService.updateBuyer(bidderModel);
        return new ResponseEntity<>(updateBuyer, HttpStatus.OK );
    }

    @Transactional
    @DeleteMapping("/buyer/delete/{id}")
    public ResponseEntity<?> deleteBuyer(@PathVariable("id") Long id)
    {
        buyerService.deleteBuyer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buyer/count")
    public long countBuyers()
    {
      return  buyerService.countBuyers();
    }

}
