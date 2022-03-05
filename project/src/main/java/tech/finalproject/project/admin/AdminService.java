package tech.finalproject.project.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private final AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {

        this.adminRepo = adminRepo;
    }

    public AdminModel addAdmin(AdminModel adminModel)
    {

        return adminRepo.save(adminModel);
    }

    public List<AdminModel> findAdmin() {

        return adminRepo.findAll();
    }

    public AdminModel fetchUserByUsernameAndPassword(String username, String password)
    {
        return adminRepo.findByUsernameAndPassword(username,password);
    }

    public AdminModel fetchUserByEmailAndPassword(String email, String password)
    {
        return adminRepo.findByEmailAndPassword(email,password);
    }

}
