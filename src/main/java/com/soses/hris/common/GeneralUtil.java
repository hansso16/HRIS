package com.soses.hris.common;

import java.time.LocalDate;

public class GeneralUtil {

	public static final LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public static final LocalDate getMaxDate() {
		return LocalDate.of(9999, 12, 31);
	}
}
