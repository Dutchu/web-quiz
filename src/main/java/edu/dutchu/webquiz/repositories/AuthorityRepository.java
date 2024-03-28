package edu.dutchu.webquiz.repositories;


import edu.dutchu.webquiz.domain.Authorities;
import edu.dutchu.webquiz.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Authorities> {
}
