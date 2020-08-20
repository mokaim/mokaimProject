package io.github.mokaim.mapper;


import io.github.mokaim.auth.CustomUserDetails;
import io.github.mokaim.domain.TestUser;
import io.github.mokaim.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {

    public CustomUserDetails identifyUser(String email);

    public void insertTest(TestUser testUser);

    public void insert_UserInfo(UserDTO userDTO);
}
