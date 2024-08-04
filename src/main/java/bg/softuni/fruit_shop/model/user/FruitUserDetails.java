package bg.softuni.fruit_shop.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;


public class FruitUserDetails extends User {

    private final Long id;
    private final String firstName;
    private final String lastName;
    public FruitUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String firstName, String lastName) {
        super(username, password, authorities);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
