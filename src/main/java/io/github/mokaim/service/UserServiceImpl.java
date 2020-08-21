package io.github.mokaim.service;


import io.github.mokaim.domain.UserDTO;
import io.github.mokaim.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public void insert_UserInfo(UserDTO userDTO) {
        userRepository.insert_UserInfo(userDTO);
        userRepository.insert_UserRole(userDTO);

    }



}
