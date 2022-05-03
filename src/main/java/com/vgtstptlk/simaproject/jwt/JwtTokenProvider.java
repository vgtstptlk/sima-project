/*
package com.vgtstptlk.simaproject.jwt;

import com.vgtstptlk.simaproject.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration.access}")
    private Long accessTokenExpiration;

    @Value("${jwt.expiration.refresh}")
    private Long refreshTokenExpiration;

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private AccessTokenBlacklistRepository accessTokenBlacklistRepository;

    public String generateAccessToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        Date now = new Date();
        Date expiration = new Date(now.getTime() + accessTokenExpiration);

        log.info("Created access JWT for user " + user.toString());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .claim("type", "access")
                .compact();
    }

    public String generateRefreshToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        Date now = new Date();
        Date expiration = new Date(now.getTime() + refreshTokenExpiration);

        log.info("Created refresh JWT for user " + user.toString());
        String result = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setId(UUID.randomUUID().toString()) //TODO: заменить на uuid
                .claim("type", "refresh")
                .compact();

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(user.getId());
        refreshToken.setRefreshToken(result);
        refreshTokenRepository.save(refreshToken);

        return result;
    }

    // TODO: 09.07.2021 Why keep the token in a DB?
    public boolean validateAccessToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            Optional<AccessTokenBlacklistEntity> accessTokenBlacklistEntity = accessTokenBlacklistRepository.findById(token);
            if (accessTokenBlacklistEntity.isPresent())
                throw new IllegalArgumentException("");
            return !claims.getBody().getExpiration().before(new Date()) && "access".equals(claims.getBody().get("type")) && !accessTokenBlacklistEntity.isPresent();
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Access JWT token " + token + " is not valid.");
            return false;
        }
    }

    // данный метод проверяет рефреш токен на валидность с точки зрения JWT, но не с точки зрения наличия в базе данных
    public boolean validateRefreshToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date()) && "refresh".equals(claims.getBody().get("type"));
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Refresh JWT token " + token + " is not valid.");
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        User user = userService.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " doesn't exist"));
        JwtUser userDetails = JwtUser.fromUserToJwtUser(user);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public JwtAuthenticationDto refresh(JwtAuthenticationDto expiredPair) {
        if (!validateRefreshToken(expiredPair.getRefreshToken()))
            throw new IllegalArgumentException("Refresh token is expired or invalid");


        RefreshToken currentRefreshToken = refreshTokenRepository.findById(expiredPair.getRefreshToken()).orElseThrow(
                () -> {
                    log.info("Refresh JWT token" + expiredPair.getRefreshToken() + " is valid, but not present in the database.");
                    throw new IllegalArgumentException("Refresh token is expired or invalid");
                }
        );

        User subject = userService.findById(currentRefreshToken.getUserId()).orElseThrow(IllegalArgumentException::new);
        String accessToken = generateAccessToken(subject);
        String refreshToken = generateRefreshToken(subject);
        JwtAuthenticationDto result = new JwtAuthenticationDto(accessToken, refreshToken, subject.getId());

        refreshTokenRepository.delete(currentRefreshToken);
        refreshTokenRepository.save(new RefreshToken(currentRefreshToken.getUserId(), refreshToken));

        return result;
    }

    public void revoke(JwtAuthenticationDto jwtAuthenticationDto) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findById(jwtAuthenticationDto.getRefreshToken());
        refreshToken.ifPresent(token -> refreshTokenRepository.delete(token));

        AccessTokenBlacklistEntity accessTokenBlacklistEntity = new AccessTokenBlacklistEntity(2, jwtAuthenticationDto.getAccessToken());
        accessTokenBlacklistRepository.save(accessTokenBlacklistEntity);
    }
}
*/
