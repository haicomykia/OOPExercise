import java.time.LocalDate;

import customer.Customer;
import warranty.WarrantyEnum;

public class App {

	public static void main(String[] args) {
		
		var taro = Customer.of("太郎");
		taro.subscribeWarranty(WarrantyEnum.THEERY_YEARS_WARRANTY, LocalDate.now());
		taro.cancelWarranty();
		
		for (WarrantyEnum warranty : WarrantyEnum.values()) {
			if (taro.hasSubscribed(warranty)) {
				System.out.println(warranty.getEndOfPeriod(taro));
				System.out.println(warranty.getWarratyName());
				break;
			}
		}
	}

}
