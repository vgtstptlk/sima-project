/*
package com.vgtstptlk.simaproject.jwt;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter implements Filter {
    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String bearerToken = ((HttpServletRequest)servletRequest).getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring(7);
            if (jwtTokenProvider.validateAccessToken(bearerToken)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(bearerToken);
                if (authentication != null)
                    SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
*/
