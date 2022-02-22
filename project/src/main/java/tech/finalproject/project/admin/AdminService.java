package tech.finalproject.project.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private final AdminRepo adminRepo;

//    @Autowired
    public AdminService(AdminRepo adminRepo) {

        this.adminRepo = adminRepo;
    }

    public AdminDetails addAdmin(AdminDetails adminDetails)
    {

        return adminRepo.save(adminDetails);
    }

    public List<AdminDetails> findAdmin() {

        return adminRepo.findAll();
    }

    public AdminDetails fetchUserByUsernameAndPassword(String username, String password)
    {
        return adminRepo.findByUsernameAndPassword(username,password);
    }

    public AdminDetails fetchUserByEmailAndPassword(String email, String password)
    {
        return adminRepo.findByEmailAndPassword(email,password);
    }

//    public List<AdminDetails> findAdmin()
//    {
//
//        return adminRepo.findAll();
//    }
}
