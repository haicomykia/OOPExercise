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
	private WarrantyEnum warraty;
	
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
		this.warraty = warranty;
		this.startDate = startDate;
		this.cancelDate = warranty.getEndOfPeriod(this);
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
		this.warraty = warranty;
		this.startDate = startDate;
	}
	
	public WarrantyEnum getWarraty() {
		return warraty;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getCancelDate() {
		return cancelDate;
	}

	public String getName() {
		return name;
	}

	/**
	 * ユーザーが保証に加入しているか
	 * @return ユーザーが保証に加入しているか？
	 */
	public boolean hasSubscribed(WarrantyEnum warranty) {
		if (this.warraty != warranty) {
			return false;
		}
		
		LocalDate endDate = this.cancelDate.isBefore(warranty.getEndOfPeriod(this)) ? 
							this.cancelDate : 
							warranty.getEndOfPeriod(this);
		
		if (LocalDate.now().compareTo(this.startDate) >= 0 && LocalDate.now().compareTo(endDate) < 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 解約
	 */
	public void cancelWarranty() {
		this.cancelDate = LocalDate.now();
	}
}
