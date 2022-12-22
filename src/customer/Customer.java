package customer;
import java.time.LocalDate;

import warranty.WarrantyEnum;

/**
 * 顧客オブジェクト
 */
public class Customer {
	
	/**
	 * 名前
	 */
	private String name;
	
	/**
	 * 加入している保証
	 */
	private WarrantyEnum warranty;
	
	/**
	 * 保証開始日
	 */
	private LocalDate startDate;
	
	/*
	 * 保証解約日
	 */
	private LocalDate cancelDate;
	
	private Customer(String name, WarrantyEnum warranty, LocalDate startDate) {
		this.name = name;
		this.warranty = warranty;
		this.startDate = startDate;
		this.cancelDate = null;
	}
	
	
	/**
	 * 保証開始日を取得
	 * @return 保証開始日
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}

	/**
	 * 顧客オブジェクトのファクトリメソッド
	 * @param name 顧客名
	 * @return 顧客オブジェクトのインスタンス
	 */
	static public Customer of(String name) {
		return new Customer(name, WarrantyEnum.BASIC_WARRANTY, LocalDate.now());
	}
	
	/**
	 * 保証に加入
	 * @param warranty 加入する保証
	 * @param startDate 開始日
	 * @return 顧客クラスのインスタンス
	 */
	public void subscribeWarranty(WarrantyEnum warranty, LocalDate startDate) {
		this.warranty = warranty;
		this.startDate = startDate;
	}
	
	public boolean isUnder(WarrantyEnum warranty) {
		if (!this.hasSubscribed(warranty)) {
			return false;
		}
		
		if (!this.startDateHasPassed()) {
			return false;
		}
		
		if (!this.hasExpiredWarranty()) {
			return true;
		}
		
		return false;
	}

	/**
	 * ユーザーが保証に加入しているか
	 * @return ユーザーが保証に加入しているか？
	 */
	private boolean hasSubscribed(WarrantyEnum warranty) {
		return this.warranty == warranty;
	}
	
	/**
	 * 解約
	 */
	public void cancelWarranty() {
		this.cancelDate = LocalDate.now();
	}
	
	/**
	 * 保証開始日を過ぎているか？
	 * @return 保証開始日 >= 今日か？
	 */
	private boolean startDateHasPassed() {
		return LocalDate.now().compareTo(this.startDate) >= 0;
	}
	
	/**
	 * 保証期間内か？
	 * @return 保証期間終了日を過ぎているか？
	 */
	private boolean hasExpiredWarranty() {
		if (this.cancelDate == null) {
			LocalDate endDate = this.startDate.plusYears(this.warranty.getYearsOfWarranty());
			return LocalDate.now().compareTo(endDate) > 0;
		}
		
		return LocalDate.now().compareTo(this.cancelDate) >= 0;
	}
}
