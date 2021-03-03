package medical.pharma.services;

import medical.pharma.pojo.Medicine;
import medical.pharma.pojo.Orders;

public interface OrderServices {

	void makeOrder() throws Exception;
	void displayPendingList();
	boolean placeOrder(Medicine x, Orders order);
}
