package com.fullstack.discuss_hub.feature.user.service;

import com.fullstack.discuss_hub.common.util.mapper.EntityToModelMapper;
import com.fullstack.discuss_hub.exception.UserNotFoundException;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.model.UserModel;
import com.fullstack.discuss_hub.feature.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EntityToModelMapper<User, UserModel> entityToModelMapper = new EntityToModelMapper<>(UserModel.class);

    @Override
    public UserModel getCurrentUserInfo() {
        User user = this.getCurrentAuthenticatedUser();
        return entityToModelMapper.map(user);
    }

    @Override
    public User getCurrentAuthenticatedUser() {
        return userRepository.findById(this.getCurrentUserId()).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Integer getCurrentUserId() {
        return getUserObject().getUserId();
    }

    @Override
    public String returnString() {
        return "String coming from backend";
    }

    private User getUserObject(){
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
