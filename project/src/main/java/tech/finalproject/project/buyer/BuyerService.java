package tech.finalproject.project.buyer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private final BuyerRepo buyerRepo;

    @Autowired
    public BuyerService(BuyerRepo buyerRepo) {

        this.buyerRepo = buyerRepo;
    }

    public BidderModel addBuyer(BidderModel bidderModel)
    {

        return buyerRepo.save(bidderModel);
    }


    public BidderModel fetchUserByUsernameAndPassword(String username, String password)
    {
        return buyerRepo.findByUsernameAndPassword(username,password);
    }

    public BidderModel fetchUserByEmailAndPassword(String email, String password)
    {
        return buyerRepo.findByEmailAndPassword(email,password);
    }

    public List<BidderModel> findallBuyers()
    {

        return buyerRepo.findAll();
    }

    public BidderModel updateBuyer(BidderModel bidderModel)
    {
        return buyerRepo.save(bidderModel);
    }

    public BidderModel findBuyerById(Long id)
    {
        return buyerRepo.findBuyerById(id).
                orElseThrow(()-> new BuyerNotFoundException("Buyer by id" + id + "was not found"));
    }

    public BidderModel findByEmail(String email)
    {
        return buyerRepo.findByEmail(email).
        orElseThrow(()-> new BuyerNotFoundException("Buyer by email" + email + "was not found"));
    }

    public void deleteBuyer(Long id)
    {
        buyerRepo.deleteBuyerById(id);
    }

    public long countBuyers()
    {
       return buyerRepo.count();
    }



}
