package tech.finalproject.project.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {


    private final SellerRepo sellerRepo;

    @Autowired
    public SellerService(SellerRepo sellerRepo) {

        this.sellerRepo = sellerRepo;
    }

    public SellerModel addSeller(SellerModel sellerModel) {
        return sellerRepo.save(sellerModel);
    }

    public SellerModel fetchUserByEmailAndPassword(String email, String password)
    {
        return sellerRepo.findByEmailAndPassword(email,password);
    }

    public List<SellerModel> findallSellers() {

        return sellerRepo.findAll();
    }

    public SellerModel updateSeller(SellerModel sellerModel) {
        return sellerRepo.save(sellerModel);
    }

    public SellerModel findSellerById(Long id) {
        return sellerRepo.findSellerById(id).
                orElseThrow(() -> new SellerNotFoundException("Seller by id" + id + "was nto found"));
    }

    public void deleteSeller(Long id) {
        sellerRepo.deleteSellerById(id);
    }
}
