package edu.dutchu.webquiz.services;

import edu.dutchu.webquiz.api.model.RegisterUserDTO;
import edu.dutchu.webquiz.api.model.RegisterUserResponseDTO;
import edu.dutchu.webquiz.domain.AppUser;
import edu.dutchu.webquiz.exceptions.EmailAlreadyUsedException;
import edu.dutchu.webquiz.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder pwdEncoder;
    private final AuthorityService authorityService;
    private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder pwdEncoder, AuthorityService authorityService) {
        this.appUserRepository = appUserRepository;
        this.pwdEncoder = pwdEncoder;
        this.authorityService = authorityService;
    }
    public RegisterUserResponseDTO registerUser(RegisterUserDTO userToRegister) {
        if (appUserRepository.existsAppUserByEmail(userToRegister.email())) {
            throw new EmailAlreadyUsedException("Provided email already exists!");
        }

        String hashPwd = pwdEncoder.encode(userToRegister.password());

        AppUser userToSave =  new AppUser(
                userToRegister.email(),
                hashPwd,
                Set.of(authorityService.getUserAuthority())
        );

        AppUser savedUser = appUserRepository.save(userToSave);

        return new RegisterUserResponseDTO(savedUser.getId());
    }


    public AppUser findUserByEmail(String email) {
        AppUser user = appUserRepository.findAppUserByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Username not found!")
        );
        System.out.println(user);
        return user;
    }

    @Transactional(readOnly = true)
    public AppUser findUserByEmailWithAuthorities(String email) {
        AppUser user = appUserRepository.findAppUserByEmailWithAuthorities(email)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return user;
    }

}
