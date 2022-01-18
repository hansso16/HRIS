package com.soses.hris.service;

import org.springframework.data.domain.Page;

import com.soses.hris.api.BaseSearchRequest;

/**
 * The Interface BaseSearchService.
 *
 * @author hso
 * @param <T> the generic type
 * @since Jan 17, 2022
 */
public interface BaseSearchService<T> {

	/**
	 * Search user.
	 *
	 * @param request the request
	 * @return the page
	 */
	Page<T> searchUser(BaseSearchRequest request);
}
