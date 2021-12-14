package com.soses.hris;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.soses.hris.cache.CacheService;
import com.soses.hris.common.ConfigParamConstants;
import com.soses.hris.common.EncryptionService;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dao.EmployeeDAO;
import com.soses.hris.entity.ConfigParam;
import com.soses.hris.entity.ConfigParamPK;
import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;
import com.soses.hris.repository.UserRepository;

@SpringBootApplication
public class HrisApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(HrisApplication.class);
	private static final org.apache.logging.log4j.Logger log4 = LogManager.getLogger(HrisApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HrisApplication.class, args);
	}

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EmployeeDAO empDao;
	
	@Autowired
	CacheService cacheService;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private EncryptionService encryptionService;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user = userRepo.findByUsername("admin");
		log.info(user.toString());
		
		List<Role> roles = user.getRoles();		
		if (roles != null) {
			for(Role role : roles) {
				log.info("ROLE: ROLE_" + role.getRoleCode());
			}
		}
		
		String ENCODED_PASSWORD = new BCryptPasswordEncoder().encode("test123");
		log.info(ENCODED_PASSWORD);
		
		log.info(empDao.getCount()+"");
		
		
		log.info("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		log.info("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		log.info("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		log.info("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		log.info("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
		
//		Cache<ConfigParamPK, ConfigParam> p = cacheManager.getCache("configParamCache", ConfigParamPK.class, ConfigParam.class);
		Cache p = cacheManager.getCache("configParamCache");
		ConfigParamPK id = new ConfigParamPK();
		id.setCode("S");
		id.setEndDate(GeneralUtil.getMaxDate());
		id.setTableName(ConfigParamConstants.EMPLOYEE);
		id.setFieldName(ConfigParamConstants.MARITAL_STATUS);
		ConfigParam result = p.get(id, ConfigParam.class);
		log.info("RESULT FROM CACHE: " + result.toString());
		
		String origString = "fdsafasdfasdfasdf";
		String enc = encryptionService.encrypt(origString);
		String dec = encryptionService.decrypt(enc);
		log.info("ORIG STRING: " + origString);
		log.info("ENCRYPTED: " + enc);
		log.info("DECRYPTED: " + dec);
		log.error("ERROR");
		log.warn("WARN");
		log4.fatal("FATAL LOG4J2");
		log4.info("LOG4J2 INFO");
		log.info("LOGBACK INFO");
		log.trace("LOGBACK TRACE");
		
		log4.info("LOG4J2 SYS ENV: " + System.getenv("SPRING_PROFILES_ACTIVE"));
		log4.info("LOG4J2 SYS PROP: " + System.getProperty("SPRING_PROFILES_ACTIVE"));
	}
	
	public static String maskCardNumber(String cardNumber, String mask) {

	    // format the number
	    int index = 0;
	    StringBuilder maskedNumber = new StringBuilder();
	    for (int i = 0; i < mask.length(); i++) {
	        char c = mask.charAt(i);
	        if (c == '#') {
	            maskedNumber.append(cardNumber.charAt(index));
	            index++;
	        } else if (c == 'x') {
	            maskedNumber.append(c);
	            index++;
	        } else {
	            maskedNumber.append(c);
	        }
	    }

	    // return the masked number
	    return maskedNumber.toString();
	}

}
