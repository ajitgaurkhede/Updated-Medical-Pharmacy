package medical.pharma.pojo;

import java.util.List;


public class Pharmacy {

	private String pharmName;
	private String licenseNumber;
	private String address;
	private long mobile;
	private List<Doctor> doctorList;


	public String getPharmName() {
		return pharmName;
	}

	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	

	@Override
	public String toString() {
		return "Pharmacy Name : " + pharmName + "\nLicense Number :" + licenseNumber + "\nAddress :" + address
				+ "\nmobile : " + mobile + "\n";
	}
	
	public Doctor serachDoctorbyName(String name) {
		return doctorList.stream().filter(x -> x.getDoctortName().equals(name)).findFirst().orElse(null);
	}
	
	

}
