package org.bs.car_rental.services.auth;

import org.bs.car_rental.dto.SignupRequest;
import org.bs.car_rental.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
