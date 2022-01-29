package com.soses.hris.cache.position;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Position;
import com.soses.hris.repository.PositionRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionFactory {

	private PositionRepository repo;
	
	@Autowired
	public PositionFactory(PositionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Position> findAll() {
		return repo.findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate.now(), LocalDate.now());
	}
}
