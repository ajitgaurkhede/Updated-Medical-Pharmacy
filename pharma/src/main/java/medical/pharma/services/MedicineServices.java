package medical.pharma.services;

import java.util.List;

import medical.pharma.pojo.Medicine;

public interface MedicineServices {

	void addMedicine() throws Exception;
	Medicine getMedicineByName(String name);
	void getInventory();
	List<Medicine> getList();
}
