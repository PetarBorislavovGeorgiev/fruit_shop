package bg.softuni.fruit_shop.service;

import bg.softuni.fruit_shop.model.dto.UserRegisterDTO;
import bg.softuni.fruit_shop.model.user.FruitUserDetails;

import java.util.Optional;

public interface UserService {

    void registerUser(UserRegisterDTO userRegistration);

    Optional<FruitUserDetails> getCurrentUser();
}
