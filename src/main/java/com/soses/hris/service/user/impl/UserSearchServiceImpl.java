package com.soses.hris.service.user.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.soses.hris.api.user.BaseUserRequest;
import com.soses.hris.api.user.UserSearchRequest;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.User;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.user.UserSearchService;

@Service("UserSearchServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserSearchServiceImpl implements UserSearchService{

	private static final Logger log = LoggerFactory.getLogger(UserSearchServiceImpl.class);
	
	private UserRepository userRepo;
	
	@Autowired
	public UserSearchServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public Page<User> searchUser(BaseUserRequest request, UserSearchRequest userReq) {
		log.info("ENTER searchUser(request, userReq)");
		String username = request.getUsername();
		Page<User> userPage = null;
		if (!StringUtil.isEmpty(username)) {
			int pageSize = 5;
			if (!StringUtil.isEmpty(userReq.getSize())) {
				pageSize = Integer.parseInt(userReq.getSize());
			}
	        int currentPage = 0;
	        if (!StringUtil.isEmpty(userReq.getPage())) {
	        	currentPage = Integer.parseInt(userReq.getPage()) - 1;
	        }
	        Pageable page = PageRequest.of(currentPage, pageSize);
	        userPage = userRepo.findByUsernameContains(username, page);
		}
		return userPage;
	}

}
