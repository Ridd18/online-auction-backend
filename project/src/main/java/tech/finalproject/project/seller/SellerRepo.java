
package tech.finalproject.project.seller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepo extends JpaRepository<SellerModel, Long>{

    Optional<SellerModel> findSellerById(Long id);

    public SellerModel findByEmailAndPassword(String email , String password);

    void deleteSellerById(Long id);
}
