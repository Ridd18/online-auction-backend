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
    public ResponseEntity<List<AdminModel>> getAllAdmin()
    {
        List<AdminModel> admin = adminService.findAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<AdminModel> addAdmin(@RequestBody AdminModel adminModel){
        AdminModel newAdmin = adminService.addAdmin(adminModel);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/admin/login")
    public AdminModel loginUser(@RequestBody AdminModel user) throws Exception {
        String tempUsername= user.getUsername();
        String tempPassword = user.getPassword();
        String tempEmail = user.getEmail();

        AdminModel userObj = null;
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

