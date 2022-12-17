import java.time.LocalDate;

import customer.Customer;
import warranty.WarrantyEnum;

public class App {

	public static void main(String[] args) {
		
		var taro = new Customer("太郎", WarrantyEnum.FIVE_YEARS_WARRANTY, LocalDate.of(2022, 12, 17));
		
		for (WarrantyEnum warranty : WarrantyEnum.values()) {
			if (warranty.hasSubscribed(taro)) {
				System.out.println(warranty.getWarratyName());
				break;
			}
		}
	}

}
