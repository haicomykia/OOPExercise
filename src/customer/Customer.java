package customer;
import java.time.LocalDate;

import warranty.WarrantyEnum;

public class Customer {
	
	/**
	 * 名前
	 */
	private String name;
	
	/**
	 * 加入している保証
	 */
	private WarrantyEnum warraty = WarrantyEnum.NONE;
	
	/**
	 * 保証開始日
	 */
	private LocalDate startDate;
	
	/*
	 * 保証解約日
	 */
	private LocalDate cancelDate = this.warraty.getEndOfPeriod(this);
	
	public Customer(String name, WarrantyEnum warranty, LocalDate startDate) {
		this.name = name;
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
		return this.warraty == warranty;
	}
}
