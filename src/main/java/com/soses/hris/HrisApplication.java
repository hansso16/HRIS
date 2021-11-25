package com.soses.hris;

import java.util.List;

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
		System.out.println(user.toString());
		
		List<Role> roles = user.getRoles();		
		if (roles != null) {
			for(Role role : roles) {
				System.out.println("ROLE: ROLE_" + role.getRoleCode());
			}
		}
		
		String ENCODED_PASSWORD = new BCryptPasswordEncoder().encode("test123");
		System.out.println(ENCODED_PASSWORD);
		
		System.out.println(empDao.getCount());
		
		
		System.out.println("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		System.out.println("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		System.out.println("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		System.out.println("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
//		System.out.println("TEST CACHE: " + cacheService.deriveMaritalStatus("S"));
		
//		Cache<ConfigParamPK, ConfigParam> p = cacheManager.getCache("configParamCache", ConfigParamPK.class, ConfigParam.class);
		Cache p = cacheManager.getCache("configParamCache");
		ConfigParamPK id = new ConfigParamPK();
		id.setCode("S");
		id.setEndDate(GeneralUtil.getMaxDate());
		id.setTableName(ConfigParamConstants.EMPLOYEE);
		id.setFieldName(ConfigParamConstants.MARITAL_STATUS);
		ConfigParam result = p.get(id, ConfigParam.class);
		System.out.println("RESULT FROM CACHE: " + result.toString());
		
		String origString = "fdsafasdfasdfasdf";
		String enc = encryptionService.encrypt(origString);
		String dec = encryptionService.decrypt(enc);
		System.out.println("ORIG STRING: " + origString);
		System.out.println("ENCRYPTED: " + enc);
		System.out.println("DECRYPTED: " + dec);
		
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
