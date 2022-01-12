package tech.finalproject.project.buyer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private final BuyerRepo buyerRepo;

    @Autowired
    public BuyerService(BuyerRepo buyerRepo) {

        this.buyerRepo = buyerRepo;
    }

    public BuyerLoginDetails addBuyer(BuyerLoginDetails buyerLoginDetails)
    {

        return buyerRepo.save(buyerLoginDetails);
    }


    public BuyerLoginDetails fetchUserByUsernameAndPassword(String username, String password)
    {
        return buyerRepo.findByUsernameAndPassword(username,password);
    }

    public BuyerLoginDetails fetchUserByEmailAndPassword(String email, String password)
    {
        return buyerRepo.findByEmailAndPassword(email,password);
    }

    public List<BuyerLoginDetails> findallBuyers()
    {

        return buyerRepo.findAll();
    }

    public BuyerLoginDetails updateBuyer(BuyerLoginDetails buyerLoginDetails)
    {
        return buyerRepo.save(buyerLoginDetails);
    }

    public BuyerLoginDetails findBuyerById(Long id)
    {
        return buyerRepo.findBuyerById(id).
                orElseThrow(()-> new BuyerNotFoundException("Buyer by id" + id + "was nto found"));
    }

    public void deleteBuyer(Long id)
    {

        buyerRepo.deleteBuyerById(id);
    }




}
