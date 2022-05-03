/*
package com.vgtstptlk.simaproject.jwt;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    boolean shouldAuthenticateAgainstThirdPartySystem = true;

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("SHA-512");
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    LdapAuthenticator ldapAuthenticator;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString(); // TODO: 01.10.2021 string -> char[]

            User userDetected = userService.findByEmail(email).orElseThrow(
                    () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", email))
            );
            com.dataframe.portal.security.jwt.JwtUser principal = new JwtUser();
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority(userDetected.getRole().getName()));
            principal.setGrantedAuthorities(grantedAuths);
            principal.setUsername(userDetected.getEmail());
            principal.setId(userDetected.getId());

            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
            return auth;


    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
*/
