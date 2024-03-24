package org.bs.car_rental.dto;

import lombok.Data;
import org.bs.car_rental.enums.UserRole;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
