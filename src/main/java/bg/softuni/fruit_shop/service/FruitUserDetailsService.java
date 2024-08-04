package bg.softuni.fruit_shop.service;

import bg.softuni.fruit_shop.model.entity.Role;
import bg.softuni.fruit_shop.model.entity.UserEntity;
import bg.softuni.fruit_shop.model.enums.RoleType;
import bg.softuni.fruit_shop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class FruitUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public FruitUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        return userRepository
                .findByEmail(email)
                .map(FruitUserDetailsService::map)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with email " + email + " not found!"));
    }


    private static UserDetails map(UserEntity userEntity){
        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of()).disabled(false).build();
    }

//    private static UserDetails map(UserEntity userEntity) {
//
//        return new FruitUserDetailsService(
//                userEntity.getId(),
//                userEntity.getEmail(),
//                userEntity.getPassword(),
//                userEntity.getRoles().stream().map(Role::getRole).map(FruitUserDetailsService::map).toList(),
//                userEntity.getFirstName(),
//                userEntity.getLastName()
//        );
//    }

    private static GrantedAuthority map(RoleType role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }
}
