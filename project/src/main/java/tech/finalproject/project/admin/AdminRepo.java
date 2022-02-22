package tech.finalproject.project.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminModel, Long>{

    public AdminModel findByUsernameAndPassword(String username, String password);

    public AdminModel findByEmailAndPassword(String email, String password);

}
