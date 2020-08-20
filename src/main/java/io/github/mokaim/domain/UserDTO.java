package io.github.mokaim.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String email;
    private String password;
    private String password_check;

}
