package warranty;

import java.time.LocalDate;

import customer.Customer;

/**
 * 保証の列挙体
 */
public enum WarrantyEnum implements IWarranty {
	
	/**
	 * なし
	 */
	NONE {
		@Override
		public LocalDate getEndOfPeriod(Customer customer) {
			return LocalDate.now();
		}
		
		@Override
		public int getWarratyCode() {
			return 101;
		}
		
		@Override
		public String getWarratyName() {
			return "未加入";
		}
	},
	/*
	 * ベーシック保証
	 */
	BASIC_WARRANTY {
		@Override
		public LocalDate getEndOfPeriod(Customer customer) {
			return customer.getStartDate().plusMonths(12);
		}
		
		@Override
		public int getWarratyCode() {
			return 101;
		}
		
		@Override
		public String getWarratyName() {
			return "ベーシック保証";
		}
	},
	/**
	 * 3年保証
	 */
	THEERY_YEARS_WARRANTY {
		@Override
		public LocalDate getEndOfPeriod(Customer customer) {
			return customer.getStartDate().plusMonths(36);
		}
		
		@Override
		public int getWarratyCode() {
			return 301;
		}
		
		@Override
		public String getWarratyName() {
			return "3年保証";
		}
	},
	
	/**
	 * 5年保証
	 */
	FIVE_YEARS_WARRANTY {
		@Override
		public LocalDate getEndOfPeriod(Customer customer) {
			return customer.getStartDate().plusMonths(60);
		}
		
		@Override
		public int getWarratyCode() {
			return 401;
		}
		
		@Override
		public String getWarratyName() {
			return "5年保証";
		}
	};
	
	
	@Override
	public boolean hasSubscribed(Customer customer) {
		
		if (!customer.hasSubscribed(this)) {
			return false;
		}
		
//		if (customer.getWarraty() != this) {
//			return false;
//		}
		
		if (LocalDate.now().isBefore(customer.getStartDate())) {
			return false;
		}
		
		// 解約済み		
		if (LocalDate.now().compareTo(customer.getCancelDate()) >= 0) {
			return false;
		}
		
		if (LocalDate.now().compareTo(getEndOfPeriod(customer)) >= 0) {
			return false;
		}
		
		return true;
	}
}
