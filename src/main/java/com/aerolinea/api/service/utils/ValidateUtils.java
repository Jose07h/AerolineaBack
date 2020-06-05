package com.aerolinea.api.service.utils;

public class ValidateUtils {
	public static Boolean isEmptyOrNull(String value) {
		if(value != null && !value.trim().isEmpty())
			return false;
		return true;
	}
	public static Boolean isEmptyOrNull(Integer value) {
		if(value != null && !value.toString().trim().isEmpty())
			return false;
		return true;
	}
	public static Boolean isEmptyOrNull(Long value) {
		if(value != null && !value.toString().trim().isEmpty())
			return false;
		return true;
	}
}
