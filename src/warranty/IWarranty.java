package warranty;

import java.time.LocalDate;

import customer.Customer;

interface IWarranty {
	/**
	 * 加入期間の終了日を返す
	 * @return 加入期間の終了日
	 */
	public LocalDate getEndOfPeriod(Customer customer);
	
	/**
	 * 保証コードを返す
	 * @return 保証コード
	 */
	public int getWarratyCode();
	
	/**
	 * 保証の名前を返す
	 * @return 保証の名前
	 */
	public String getWarratyName();
	
	/**
	 * 顧客が当該保証に申し込んでいて、期間内か？
	 * @param customer 顧客
	 * @return 当該保証に申し込んでいて、期間内か？
	 */
	public boolean hasSubscribed(Customer customer);
}
