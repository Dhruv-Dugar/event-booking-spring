package com.dhruvdugar.APIGateway.Controller;


import com.dhruvdugar.APIGateway.models.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @GetMapping("/login")
    ResponseEntity<AuthenticationResponse> login(
            @AuthenticationPrincipal OidcUser oidcUser,
            Model model,
            @RegisteredOAuth2AuthorizedClient("okta")OAuth2AuthorizedClient oAuth2AuthorizedClient
            ) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setUserId(oidcUser.getEmail());
        authenticationResponse.setAccessToken(oAuth2AuthorizedClient.getAccessToken().getTokenValue());
        authenticationResponse.setRefreshToken(Objects.requireNonNull(oAuth2AuthorizedClient.getRefreshToken()).getTokenValue());
        authenticationResponse.setExpiresAt(Objects.requireNonNull(oAuth2AuthorizedClient.getAccessToken()).getExpiresAt().getEpochSecond());
        authenticationResponse.setAuthorityList(oidcUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
