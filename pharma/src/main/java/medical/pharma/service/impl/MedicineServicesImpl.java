package medical.pharma.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import medical.pharma.pojo.Medicine;
import medical.pharma.services.MedicineServices;

public class MedicineServicesImpl implements MedicineServices {

	private List<Medicine> medicinesList;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public List<Medicine> getMedicinesList() {
		return medicinesList;
	}

	public void setMedicinesList(List<Medicine> medicinesList) {
		this.medicinesList = medicinesList;
	}

	public List<Medicine> getList() {
		return medicinesList;
	}

	@Override
	public String toString() {
		return "medicinesList=" + medicinesList;
	}

	public void addMedicine() throws Exception {
		Medicine med = new Medicine();
		System.out.println("enter medicine name :");
		String brandName = reader.readLine();
		med.setBrandName(brandName);
		System.out.println("enter medicine price :");
		double price = Double.valueOf(reader.readLine());
		med.setPrice(price);
		System.out.println("enter medicine quantity :");
		int quantity = Integer.valueOf(reader.readLine());
		med.setQuantity(quantity);
		med.setStatus(" ");
		medicinesList.add(med);
	}

	public Medicine getMedicineByName(String name) {
		return medicinesList.stream().filter(x -> x.getBrandName().equals(name)).findFirst().orElse(null);
	}

	public void getInventory() {
		medicinesList.forEach(System.out::println);
	}

}
