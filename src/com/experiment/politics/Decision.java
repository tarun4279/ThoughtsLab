package com.experiment.politics;

import java.util.Arrays;
import java.util.List;

public enum Decision {

	POSITIVE("positive"),NEGATIVE("negative"),NEUTRAL("neutral");

	private String value;
	
	private Decision(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value; 
	}
	
	public static List<Decision> getValues() {
		Decision[] array = {POSITIVE, NEUTRAL, NEGATIVE};
		return Arrays.asList(array);
	}
}
