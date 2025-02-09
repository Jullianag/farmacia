package com.projeto.farmacia.services;

import com.projeto.farmacia.entities.Role;
import com.projeto.farmacia.entities.User;
import com.projeto.farmacia.projections.UserDetailsProjection;
import com.projeto.farmacia.repositories.UserRepository;
import com.projeto.farmacia.util.CustomUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserUtil customUserUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getFirst().getPassword());

        for (UserDetailsProjection projection : result) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }

        protected User authenticated() {
            try {
                String username = customUserUtil.getLoggedUsername();
                return userRepository.findByEmail(username);
            } catch (Exception e) {
                throw new UsernameNotFoundException("Email not found");
            }

        }

}
