package tech.finalproject.project.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminDetails, Long>{

    public AdminDetails findByUsernameAndPassword(String username, String password);

    public AdminDetails findByEmailAndPassword(String email, String password);

}
