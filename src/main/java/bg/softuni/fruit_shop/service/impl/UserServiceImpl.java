package bg.softuni.fruit_shop.service.impl;

import bg.softuni.fruit_shop.model.dto.UserRegisterDTO;
import bg.softuni.fruit_shop.model.entity.UserEntity;
import bg.softuni.fruit_shop.model.user.FruitUserDetails;
import bg.softuni.fruit_shop.repository.UserRepository;
import bg.softuni.fruit_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public UserServiceImpl(ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegistration) {
        userRepository.save(map(userRegistration));
    }

    @Override
    public Optional<FruitUserDetails> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null &&
                authentication.getPrincipal() instanceof FruitUserDetails fruitUserDetails) {
            return Optional.of(fruitUserDetails);
        }
        return Optional.empty();
    }

    private UserEntity map(UserRegisterDTO userRegisterDTO) {
        UserEntity mappedEntity = modelMapper.map(userRegisterDTO, UserEntity.class);

        mappedEntity.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        return mappedEntity;
    }

//    public void registerUser(UserRegisterDTO userRegisterDTO) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName(userRegisterDTO.getFirstName());
//        userEntity.setMiddleName(userRegisterDTO.getMiddleName());
//        userEntity.setLastName(userRegisterDTO.getLastName());
//        userEntity.setEmail(userRegisterDTO.getEmail());
//        userEntity.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
//        userEntity.setPhoneNumber(userRegisterDTO.getPhoneNumber());
//        userRepository.save(userEntity);
//    }


}
