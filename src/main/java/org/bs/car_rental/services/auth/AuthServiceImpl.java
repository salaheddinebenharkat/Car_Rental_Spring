package org.bs.car_rental.services.auth;

import lombok.RequiredArgsConstructor;
import org.bs.car_rental.dto.SignupRequest;
import org.bs.car_rental.dto.UserDto;
import org.bs.car_rental.entities.User;
import org.bs.car_rental.enums.UserRole;
import org.bs.car_rental.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepo userRepo;

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.USER);
        User createdUser = userRepo.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepo.findFirstByEmail(email).isPresent();
    }
}
