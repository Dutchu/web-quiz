package edu.dutchu.webquiz.services;

import edu.dutchu.webquiz.domain.Authorities;
import edu.dutchu.webquiz.domain.Authority;
import edu.dutchu.webquiz.repositories.AuthorityRepository;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


@Service
public class AuthorityService {
    private Authority userAuth;
    private Authority adminAuth;
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
    @PostConstruct
    public void init() {
        this.userAuth = createAuthority(Authorities.ROLE_USER);
        this.adminAuth = createAuthority(Authorities.ROLE_ADMIN);
    }
    private Authority createAuthority(Authorities name) {
        Authority savedAuth = authorityRepository.save(new Authority(name));
        return  savedAuth;
    }

    public Authority getUserAuthority() {
        return this.userAuth;
    }
    public Authority getAdminAuthority() {
        return this.adminAuth;
    }

    public boolean exists(Authority authority) {
        return false;
    }
}
