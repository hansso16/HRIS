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

import com.soses.hris.api.BaseSearchRequest;
import com.soses.hris.api.user.UserSearchRequest;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.User;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.user.UserSearchService;

@Service("UserSearchServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserSearchServiceImpl implements UserSearchService<User> {

	private static final Logger log = LoggerFactory.getLogger(UserSearchServiceImpl.class);
	
	private UserRepository userRepo;
	
	@Autowired
	public UserSearchServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public Page<User> searchUser(BaseSearchRequest userReq) {
		log.info("ENTER searchUser(request, userReq)");
		
		UserSearchRequest request = null; 
		String username = null;
		Page<User> userPage = null;
		if (userReq != null) {
			request = (UserSearchRequest) userReq;
			username = request.getUsername();
		}
		
		if (!StringUtil.isEmpty(username) && request != null) {
			int pageSize = 5;
			if (!StringUtil.isEmpty(request.getSize())) {
				pageSize = Integer.parseInt(request.getSize());
			}
	        int currentPage = 0;
	        if (!StringUtil.isEmpty(request.getPage())) {
	        	currentPage = Integer.parseInt(request.getPage()) - 1;
	        }
	        Pageable page = PageRequest.of(currentPage, pageSize);
	        userPage = userRepo.findByUsernameContains(username, page);
		}
		return userPage;
	}

}
