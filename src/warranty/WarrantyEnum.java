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
			return customer.getStartDate();
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
			return customer.getStartDate().plusYears(1);
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
			return customer.getStartDate().plusYears(3);
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
			return customer.getStartDate().plusYears(5);
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
	public boolean isAgaint(Customer customer) {
		if (!customer.hasSubscribed(this)) {
			return false;
		}
		
		if (LocalDate.now().compareTo(customer.getStartDate()) < 0) {
			return false;
		}
		
		// 解約していない
		if (customer.getCancelDate() == null) {
			LocalDate endDate = this.getEndOfPeriod(customer);
			if (!endDate.isAfter(LocalDate.now())) {
				return true;
			}
			
			return false;
		}
		
		// 解約
		if (!customer.getCancelDate().isAfter(LocalDate.now())) {
			return true;
		}
		
		return false;
	}
}
