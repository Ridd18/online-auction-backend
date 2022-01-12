package tech.finalproject.project.seller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.seller.SellerLoginDetails;
import tech.finalproject.project.seller.SellerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auction")
public class SellerResource {

    private final SellerService sellerService;


    public SellerResource(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    @GetMapping("/seller/all")
    public ResponseEntity<List<SellerLoginDetails>> getAllSellers()
    {
        List<SellerLoginDetails> seller = sellerService.findallSellers();
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @GetMapping("/seller/find/{id}")
    public ResponseEntity<SellerLoginDetails> getSellerById(@PathVariable("id") Long id)
    {
        SellerLoginDetails seller = sellerService.findSellerById(id);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @PostMapping("/seller/add")
    public ResponseEntity<SellerLoginDetails> addBuyer(@Valid @RequestBody SellerLoginDetails sellerLoginDetails)
    {
        SellerLoginDetails newseller = sellerService.addSeller(sellerLoginDetails);
        return new ResponseEntity<>(newseller, HttpStatus.CREATED);
    }


    @PostMapping("/seller/login")
    public SellerLoginDetails loginUser(@RequestBody SellerLoginDetails user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        SellerLoginDetails userObj = null;
        if (tempEmail != null && tempPassword != null)
        {
            userObj = sellerService.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }
//        if (tempUsername != null && tempPassword != null)
//        {
//            userObj = buyerService.fetchUserByUsernameAndPassword(tempUsername,tempPassword);
//        }
        if (userObj == null)
        {
            throw new Exception("User does not exist");
        }

        return userObj;
    }



    @PutMapping("/seller/update")
    public ResponseEntity<SellerLoginDetails> updateseller(@RequestBody SellerLoginDetails sellerLoginDetails)
    {
        SellerLoginDetails updateseller = sellerService.updateSeller(sellerLoginDetails);
        return new ResponseEntity<>(updateseller, HttpStatus.OK );
    }

    @Transactional
    @DeleteMapping("/seller/delete/{id}")
    public ResponseEntity<?> deleteBuyer(@PathVariable("id") Long id)
    {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
