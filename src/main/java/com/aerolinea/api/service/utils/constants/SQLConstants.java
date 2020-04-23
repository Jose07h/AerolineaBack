package com.aerolinea.api.service.utils.constants;

public enum SQLConstants {
	SELECT("SELECT "), FROM("FROM "), ORDER("ORDER "), BY("BY "), GROUP("GROUP "), ALL("* "),SELECT_ALL("SELECT * FROM "),WHERE("WHERE");

	private String constant;

	private SQLConstants(String constant) {
		this.constant = constant;
	}

	public String getConstant() {
		return this.constant;
	}

}
