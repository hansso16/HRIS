	package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class ConfigParameterPK.
 *
 * @author hso
 * @since 15 Nov 2021
 */
@Embeddable
public class ConfigParamPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2699260467382359568L;

	/** The table name. */
	@Column(name="TABLE_NAME", length=100)
	private String tableName;
	
	/** The field name. */
	@Column(name="FIELD_NAME", length=10)
	private String fieldName;
	
	/** The code. */
	@Column(name="CODE", length=100)
	private String code;
	
	/** The end date. */
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	public String getTableName() {
		return tableName;
	}
	
	/**
	 * Sets the table name.
	 *
	 * @param tableName the new table name
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * Sets the field name.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(code, fieldName, tableName);
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigParamPK other = (ConfigParamPK) obj;
		return Objects.equals(code, other.code) && Objects.equals(fieldName, other.fieldName)
				&& Objects.equals(tableName, other.tableName);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ConfigParameterPK [tableName=" + tableName + ", fieldName=" + fieldName + ", code=" + code + "]";
	}
	
}
