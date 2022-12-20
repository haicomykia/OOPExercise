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
	 * ユーザーが保証に加入しているか
	 * @param customer 顧客オブジェクト
	 * @return ユーザーが保証に加入していて期間内か？
	 */
	public boolean isAgaint(Customer customer);
}
