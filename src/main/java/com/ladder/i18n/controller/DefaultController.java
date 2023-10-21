package com.ladder.i18n.controller;
import com.ladder.i18n.model.TranslationRequest;
import com.ladder.i18n.utility.constants.TranslationConstants;
import com.ladder.i18n.utility.token.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DefaultController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello, internationalization service is up and running...";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, internationalization service is up and running...";
    }

    @GetMapping("/test/generate-token/admin-moderator")
    public String generateTokenBoth() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_MODERATOR");
        return JWTUtils.generateToken("Admin Moderator user", roles);
    }
    @GetMapping("/test/generate-token/admin")
    public String generateTokenAdmin() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        return JWTUtils.generateToken("Admin user", roles);
    }
    @GetMapping("/test/generate-token/moderator")
    public String generateTokenModerator() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_MODERATOR");
        return JWTUtils.generateToken("Moderator user", roles);
    }
}
