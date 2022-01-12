package tech.finalproject.project.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.admin.AdminDetails;
import tech.finalproject.project.buyer.BuyerLoginDetails;

public interface AdminRepo extends JpaRepository<AdminDetails, Long>{

    public AdminDetails findByUsernameAndPassword(String username, String password);

    public AdminDetails findByEmailAndPassword(String email, String password);

}
