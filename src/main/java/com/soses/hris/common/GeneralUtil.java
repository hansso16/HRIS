package com.soses.hris.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneralUtil {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLL dd, yyyy");

	public static final LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public static final LocalDate getMaxDate() {
		return LocalDate.of(9999, 12, 31);
	}
	
	public static final String formatDate(LocalDate date) {
		return date.format(formatter);
	}
	
	public static boolean isListEmpty(List<?> list) {
		return (list == null || list.size() == 0)? true:false;
	}
}
