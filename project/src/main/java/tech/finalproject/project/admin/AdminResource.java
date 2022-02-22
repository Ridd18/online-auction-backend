package tech.finalproject.project.admin;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class AdminResource {

    private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<AdminDetails>> getAllAdmin()
    {
        List<AdminDetails> admin = adminService.findAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<AdminDetails> addAdmin(@RequestBody AdminDetails adminDetails){
        AdminDetails newAdmin = adminService.addAdmin(adminDetails);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/admin/login")
    public AdminDetails loginUser(@RequestBody AdminDetails user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        AdminDetails userObj = null;
        if (tempEmail != null && tempPassword != null)
        {
            userObj = adminService.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }

        if (userObj == null)
        {
            throw new Exception("User does not exist");
        }

        return userObj;
    }
}

