package com.soses.hris.cache.position;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Position;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionService {

	private PositionFactory factory;

	@Autowired
	public PositionService(PositionFactory factory) {
		super();
		this.factory = factory;
	}

//	@Cacheable(value="provinceCache")
	public List<Position> findAll() {
		return factory.findAll();
	}
}
