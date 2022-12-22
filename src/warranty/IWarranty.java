package warranty;

interface IWarranty {
	/**
	 * 加入期間の年数を返す
	 * @return 加入期間の年数
	 */
	public int getYearsOfWarranty();
	
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
}
