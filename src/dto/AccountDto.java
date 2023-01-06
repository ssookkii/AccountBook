package dto;

public class AccountDto {
	
	// 항목들
	private String date;
	private int year, month, day; 		// 년 월 일  		ex )	22/12/24	22/12/27		
	private String use; 					// 용도					영화관람		월급
	private String classify; 				// 수입, 지출				지출			수입
	private int money;						// 금액					25000		3000000
	private String memo; 					// 내용					아바타 봐씀	12월 급여

	public AccountDto() {
		// TODO Auto-generated constructor stub
	}

	public AccountDto(int year, int month, int day, String use, String classify, int money, String memo) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
		this.date = year+"/"+month+"/"+day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(int year, int month, int day) {
		this.date = year+"/"+month+"/"+day;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return  year + "년 " + month + "월 " + day + "일 "+": " + use + ", "
				+ classify + ", " + money + "원 \t\t 메모: " + memo;
	}

}