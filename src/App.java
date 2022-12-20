import java.time.LocalDate;

import customer.Customer;
import warranty.WarrantyEnum;

public class App {

	public static void main(String[] args) {
		
		var taro = Customer.of("太郎");
		taro.subscribeWarranty(WarrantyEnum.BASIC_WARRANTY, LocalDate.of(2021, 12, 20));
//		taro.cancelWarranty();
		
		for (WarrantyEnum warranty : WarrantyEnum.values()) {
			if (warranty.isAgaint(taro)) {
				System.out.println(warranty.getEndOfPeriod(taro));
				System.out.println(warranty.getWarratyName());
				break;
			}
		}
	}

}
