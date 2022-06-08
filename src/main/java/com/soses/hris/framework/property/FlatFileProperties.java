package com.soses.hris.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * The Class FlatFileProperties.
 *
 * @author hso
 * @since Mar 17, 2022
 */
@PropertySource("classpath:/properties/${hris_env}/flatfile.properties")
@Component
public class FlatFileProperties {

	/** The emp img path. */
	@Value("${employee.image.base.path}")
    protected String empImgPath;

	/**
	 * Gets the emp img path.
	 *
	 * @return the emp img path
	 */
	public String getEmpImgPath() {
		return empImgPath;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "FlatFileProperties [empImgPath=" + empImgPath + "]";
	}
	
}
