package com.tsq.constant;

public enum Gender {
	MALE("male","男"),
	FEMALE("female","女");
	private String genderEN;
	private String genderCN;
	Gender(String genderEN,String genderCN){
		this.genderEN=genderEN;
		this.genderCN=genderCN;
	}
	public String getGenderEN() {
		return genderEN;
	}
	public void setGenderEN(String genderEN) {
		this.genderEN = genderEN;
	}
	public String getGenderCN() {
		return genderCN;
	}
	public void setGenderCN(String genderCN) {
		this.genderCN = genderCN;
	}
	public static Gender getInstance(String gender) {
		if("male".equals(gender)||"男".equals(gender))
			return Gender.MALE;
		else if("female".equals(gender)||"女".equals(gender)){
			return Gender.FEMALE;
		}
		return null;
	}
	
	
}
