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
    public String register(UserDTO userDTO){



        String password = userDTO.getPassword();
        String password_check = userDTO.getPassword_check();
        String realPassword = null;


        if(password.equals(password_check)){
            log.info("똑같");
            realPassword = bCryptPasswordEncoder.encode(password);

            userDTO.setPassword(null);
            userDTO.setPassword(realPassword);

            userService.insert_UserInfo(userDTO);

            return "success";
        }

        return "faild";
    }



}
