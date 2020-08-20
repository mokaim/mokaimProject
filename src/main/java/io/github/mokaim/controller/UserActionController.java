package io.github.mokaim.controller;


import io.github.mokaim.domain.UserDTO;
import io.github.mokaim.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class UserActionController {


    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/register")
    public UserDTO register(UserDTO userDTO){



        String password = userDTO.getPassword();
        String password_check = userDTO.getPassword_check();
        String realPassword = null;


        if(password.equals(password_check)){
            log.info("똑같");
            log.info("pass : " + password);
            log.info("pass_check : " + password_check);

            realPassword = bCryptPasswordEncoder.encode(password);

            userDTO.setPassword(null);
            userDTO.setPassword(realPassword);
            userDTO.setRole("MEMBER");


            userService.insert_UserInfo(userDTO);

            userDTO.setValidation("true");

            return userDTO;
        }else{
            log.info("다름");
            userDTO.setValidation("false");
        }

        return userDTO;
    }



}
