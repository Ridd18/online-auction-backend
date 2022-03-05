package tech.finalproject.project.seller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<SellerModel>> getAllSellers()
    {
        List<SellerModel> seller = sellerService.findAllSellers();
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @GetMapping("/seller/find/{id}")
    public ResponseEntity<SellerModel> getSellerById(@PathVariable("id") Long id)
    {
        SellerModel seller = sellerService.findSellerById(id);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @PostMapping("/seller/add")
    public ResponseEntity<SellerModel> addBuyer(@Valid @RequestBody SellerModel sellerModel)
    {
        SellerModel newseller = sellerService.addSeller(sellerModel);
        return new ResponseEntity<>(newseller, HttpStatus.CREATED);
    }


    @PostMapping("/seller/login")
    public SellerModel loginUser(@RequestBody SellerModel user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        SellerModel userObj = null;
        if (tempEmail != null && tempPassword != null)
        {
            userObj = sellerService.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }

        if (userObj == null)
        {
            throw new Exception("User does not exist");
        }

        return userObj;
    }



    @PutMapping("/seller/update")
    public ResponseEntity<SellerModel> updateseller(@RequestBody SellerModel sellerModel)
    {
        SellerModel updateseller = sellerService.updateSeller(sellerModel);
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
