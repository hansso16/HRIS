package com.soses.hris.service.user;

import org.springframework.data.domain.Page;

import com.soses.hris.api.user.BaseUserRequest;
import com.soses.hris.api.user.UserSearchRequest;
import com.soses.hris.entity.User;

public interface UserSearchService {

	Page<User> searchUser(BaseUserRequest request, UserSearchRequest userSearchRequest);
}
