package tech.finalproject.project.buyer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.buyer.BuyerService;
import tech.finalproject.project.product.ProductDetails;

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
    public ResponseEntity<List<BuyerLoginDetails>> getAllBuyers()
    {
        List<BuyerLoginDetails> buyer = buyerService.findallBuyers();
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @GetMapping("/buyer/find/{id}")
    public ResponseEntity<BuyerLoginDetails> getBuyerById(@PathVariable("id") Long id)
    {
        BuyerLoginDetails buyer = buyerService.findBuyerById(id);
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }


    @GetMapping("/buyer/findEmail/{email}")
    public ResponseEntity<BuyerLoginDetails> getBuyerByEmail(@PathVariable("email") String email)
    {
        BuyerLoginDetails buyer = buyerService.findByEmail(email);
        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @PostMapping("/buyer/add")
    public ResponseEntity<BuyerLoginDetails> addBuyer(@Valid @RequestBody BuyerLoginDetails buyerLoginDetails)
    {
//        String tempPhoneNo = newBuyer.getPhoneNo();
//        String tempEmail = newBuyer.getEmail();
//        String tempUsername= newBuyer.getUsername();
//        String tempPassword = newBuyer.getPassword();
//        BuyerLoginDetails userObj = null;
//
//        if(tempEmail != null && tempPassword != null && tempUsername != null && tempPhoneNo != null
//            && tempPassword >= )
        BuyerLoginDetails newBuyer = buyerService.addBuyer(buyerLoginDetails);
        return new ResponseEntity<>(newBuyer, HttpStatus.CREATED);
    }

    @PostMapping("/buyer/login")
    public BuyerLoginDetails loginUser(@RequestBody BuyerLoginDetails user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        BuyerLoginDetails userObj = null;
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
    public ResponseEntity<BuyerLoginDetails> updateBuyer(@RequestBody BuyerLoginDetails buyerLoginDetails)
    {
        BuyerLoginDetails updateBuyer = buyerService.updateBuyer(buyerLoginDetails);
        return new ResponseEntity<>(updateBuyer, HttpStatus.OK );
    }

    @Transactional
    @DeleteMapping("/buyer/delete/{id}")
    public ResponseEntity<?> deleteBuyer(@PathVariable("id") Long id)
    {
        buyerService.deleteBuyer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
