package com.umgcodechallenge.umgcodechallenge.Authorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codechallenge")
public class ClientCredentialController {

    @GetMapping("")
    public void clientCredentialAuthorization() {
        ClientCredentialsAuthorization.clientCredentials_Sync();
    }
}
