package medical.pharma.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import medical.pharma.pojo.Medicine;
import medical.pharma.pojo.Orders;
import medical.pharma.services.MedicineServices;
import medical.pharma.services.OrderServices;

public class OrderServicesImpl implements OrderServices {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Medicine medi;
	private MedicineServices mdService;

	public MedicineServices getMdService() {
		return mdService;
	}

	public void setMdService(MedicineServices mdService) {
		this.mdService = mdService;
	}

	public Medicine getMedi() {
		return medi;
	}

	public void setMedi(Medicine medi) {
		this.medi = medi;
	}

	@Override
	public void makeOrder() throws Exception {

		Orders order = new Orders();
		int flag;
		System.out.println("enter medicine name for order :");
		String name = reader.readLine();
		order.setMedicineName(name);
		System.out.println("enter medicine quantity :");
		int quantity = Integer.valueOf(reader.readLine());
		order.setQuantity(quantity);
		System.out.println(mdService.getList());

		for (Medicine x : mdService.getList()) {
			if (x.getBrandName().equals(name)) {
				if (x.getQuantity() != 0 && order.getQuantity() <= x.getQuantity()) {
					System.out.println(x.getBrandName() + " Current Available " + x.getQuantity());
					x.setQuantity(x.getQuantity() - order.getQuantity());
					System.out.println("Updated : " + x.getQuantity());
				} else {
					System.out.println("Out Of Stock or Enter lower value than Quantity : ");
					System.out.println("Do u Want add Stock Press 1 for yes or else 2 : ");
					flag = Integer.valueOf(reader.readLine());
					if (flag == 1) {
						x.setQuantity(x.getQuantity() + order.getQuantity());
						System.out.println("Stock Added: ");
						System.out.println(x.getBrandName() + " Current Available : " + x.getQuantity());
					}
				}
				if (placeOrder(x, order)) {
					System.out.println("order placed sucessfull");
				} else {
					System.out.println("oops order is pending because quantity value is more than 5");
				}
			}
		}

	}

	/*
	 * our system is not capable to handle more than 5 quantities order otherwise it
	 * will go for pending
	 */

	@Override
	public boolean placeOrder(Medicine medicine, Orders orders) {
		if (orders.getQuantity() > 5) {
			medicine.setStatus("pending");
			return false;
		} else {
			medicine.setStatus("completed");
			return true;
		}

	}

	@Override
	public void displayPendingList() {
		for (Medicine m : mdService.getList()) {
			if (m.getStatus().equals("pending"))
				System.out.println(
						"Name : " + m.getBrandName() + "\tprice : " + m.getPrice() + "\tStatus : " + m.getStatus());

		}

	}

}
