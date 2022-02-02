package com.soses.hris;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soses.hris.cache.position.PositionCache;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Position;
import com.soses.hris.repository.DivisionRepository;

@SpringBootApplication
public class HrisApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(HrisApplication.class);
	private static final org.apache.logging.log4j.Logger log4 = LogManager.getLogger(HrisApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HrisApplication.class, args);
	}

	@Autowired
	private DivisionRepository divisionRepo;
	
	@Autowired
	private PositionCache positionCache;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Division> diviList = divisionRepo.findAll();
		
		for (Division divi : diviList) {
			log4.info(divi.toString());
		}
		
		List<Position> positionList = positionCache.getPositionListByDivision("110");
		for (Position position : positionList) {
			log.info(position.toString());
		}
		
		log4.info("Cache Completed. System ready");
	}
}
