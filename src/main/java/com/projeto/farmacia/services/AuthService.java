package com.projeto.farmacia.services;

import com.projeto.farmacia.entities.User;
import com.projeto.farmacia.services.exceptions.ForbiddenException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;

    public void validateForAdmin(long userId) {
        User me = userService.authenticated();

        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
