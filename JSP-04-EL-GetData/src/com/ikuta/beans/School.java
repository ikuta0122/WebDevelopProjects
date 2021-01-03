package com.ikuta.beans;

public class School {
	private String schoolName;
	private String address;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", address=" + address + "]";
	}

	public School() {
		super();
	}

	public School(String schoolName, String address) {
		super();
		this.schoolName = schoolName;
		this.address = address;
	}

}
