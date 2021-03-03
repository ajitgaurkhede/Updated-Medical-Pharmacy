package medical.pharma;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import medical.pharma.pojo.Pharmacy;
import medical.pharma.service.impl.MedicineServicesImpl;
import medical.pharma.service.impl.OrderServicesImpl;
import medical.pharma.services.MedicineServices;
import medical.pharma.services.OrderServices;

public class App {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("medical/pharma/resources/pharma-config.xml");
		Pharmacy pharm = context.getBean("pharmacy", Pharmacy.class);
		System.out.println(pharm.toString());
		MedicineServices medicineServ = context.getBean("medicineServ", MedicineServicesImpl.class);
		OrderServices order = context.getBean("order", OrderServicesImpl.class);

		char exit = 'a';
		do {
			int choice;
			System.out.println("Enter your choice");
			System.out.println(
					"1.Add Medicine : \n" + "2.Search medicine by brand name : \n" + "3 Medicine Inventory : \n"
							+ "4.Order a drug and Add Stock : \n" + "5.Display list of all pending orders : \n"
							+ "6.Search a doctor by name : \n" + "7.Get pharmacy information : \n" + "8.Exit \n");
			choice = Integer.valueOf(reader.readLine());
			switch (choice) {
			case 1:
				medicineServ.addMedicine();
				break;
			case 2:
				System.out.println("enter medicine name for search : ");
				String name = reader.readLine();
				System.out.println(medicineServ.getMedicineByName(name));
				break;
			case 3:
				medicineServ.getInventory();
				break;
			case 4:
				order.makeOrder();
				break;
			case 5:
				order.displayPendingList();
				break;
			case 6:
				pharm.getDoctorList().forEach(System.out::println);
				System.out.println("Enter Doctor Name for Search:");
				String docName = reader.readLine();
				System.out.println(pharm.serachDoctorbyName(docName));
				break;
			case 7:
				System.out.println(pharm.toString());
				break;
			case 8:
				exit = 'e';
				System.out.println("Thanks for used our services");
				break;
			default:
				System.out.println("Please Enter Valid Choice :");
			}

		} while (exit != 'e');

	}
}
