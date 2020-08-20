package io.github.mokaim.service;


import io.github.mokaim.domain.UserDTO;
import io.github.mokaim.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public void insert_UserInfo(UserDTO userDTO) {
        userRepository.insert_UserInfo(userDTO);
    }
}
