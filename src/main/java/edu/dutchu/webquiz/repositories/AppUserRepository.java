package edu.dutchu.webquiz.repositories;


import edu.dutchu.webquiz.api.model.RegisterUserResponseDTO;
import edu.dutchu.webquiz.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;
import java.util.logging.Logger;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByEmail(String email);
    @Query("SELECT DISTINCT u FROM AppUser u LEFT JOIN FETCH u.authorities WHERE u.email = :email")
    Optional<AppUser> findAppUserByEmailWithAuthorities(@Param("email") String email);
    boolean existsAppUserByEmail(String email);
}
