package com.fullstack.discuss_hub.feature.user.service;

import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.model.UserModel;

public interface UserService {

    UserModel getCurrentUserInfo();
    User getCurrentAuthenticatedUser();
    Integer getCurrentUserId();
}
