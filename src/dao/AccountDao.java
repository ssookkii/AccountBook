package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import dto.AccountDto;


public class AccountDao {
	
	Scanner sc = new Scanner(System.in);
	
	private List<AccountDto> list = new ArrayList<AccountDto>();

	// 확인을 위한 임시 데이터 저장.
	public AccountDao() {
		list.add(new AccountDto(2022, 12,31, "영화", "지출", 17000, "영웅"));
		list.add(new AccountDto(2023, 01, 01, "야식", "지출", 18000, "치킨"));
		list.add(new AccountDto(2023, 01, 01, "새해알바", "수입", 60000, "백화점알바"));
		list.add(new AccountDto(2023, 01, 11, "옷", "지출", 35000, "쇼핑"));
		list.add(new AccountDto(2023, 02, 10, "세뱃돈", "수입", 100000, "세뱃돈"));
		list.add(new AccountDto(2023, 05, 05, "월급", "수입", 2000000, "첫월급"));
		list.add(new AccountDto(2023, 06, 27, "외식", "지출", 150000, "첫월급 한턱"));
		
	}
	
	
	
	
	public void insert() {
		
		System.out.print("날짜를 입력하세요 ex) 2022/12/31 : ");	
		String date = sc.next();
		
		// 입력받은 값을 "/" 구분자별로 저장
		StringTokenizer st = new StringTokenizer(date, "/");
	
		// 배열의 갯수를 정해줌. 나눠진 토큰의 갯수를 토대로 배열을 생성
		int[] tokens = new int[st.countTokens()];
		int idx = 0;
		

		//나눠진 토큰을 token에 저장한다. 이때 String으로 입력 받았지만 사용은 Int 값이 필요하므로 형변환
		while(st.hasMoreTokens()) { // 가져올 토큰이 있으면 true, 없으면 false
			int token =Integer.parseInt(st.nextToken());
			tokens[idx]=token;
			idx++;
		}
		
		//입력에 따르면 첫번재 토큰은 년도, 두번째 토큰은 월, 세번째 토큰은 일 이므로 나눠진 토큰을 각 값에 저장한다.
		// 이렇게 하면 날짜를 년도, 월, 일자를 따로 받지 않고 한번에 입력받은 후 데이터에서는 나눠서 저장 가능하다. 
		int year = tokens[0];
		int month = tokens[1];
		int day = tokens[2];
		
		
		
		
		System.out.print("용도를 입력하세요 : ");
		String use = sc.next();
		
		System.out.print("수입 / 지출 을 입력하세요 :");
		String classify = sc.next();
		
		System.out.println("금액을 입력하세요 : ");
		int money = sc.nextInt();
		
		System.out.println("메모를 입력하세요 : ");
		String memo = sc.next();
		
		// 입력받은 값으로 list 에 저장.
		AccountDto dto = new AccountDto(year, month, day, use, classify, money, memo);
		list.add(dto);
		


	}
	
	public void delete() {
		//위치 확인 위한 인덱스 값
		int index = -1;
		
		//날짜, 용도 받아서 지우기
		System.out.print("삭제를 날짜를 입력하세요 ex) 2022/12/31 : ");
		String date = sc.next();
		
		//용도 확인 위해 해당 날짜 모두 출력
		//이때 AccountDto값에 우리는 date값을 year, month, day로 입력받았지만 date값을 생성해주는 메서드를 하나 생성해주었다. 
		//year, month, day를 따로 활용하지 않고 한번에 사용할 수 있도록 변환하여 코드를 줄였다. 
		for (int i = 0; i < list.size(); i++) {
			AccountDto dto = list.get(i);
			if(date.equals(dto.getDate())) {
				System.out.println(list.get(i));

			}
		}
		
		//출력된 가계부를 보고 삭제를 원하는 용도를 입력.
		System.out.print("삭제를 원하는 용도를 입력하세요 : ");
		String use = sc.next();
		
		
		// 날짜와 용도가 같다면 해당 인덱스의 값을 변경해주고, 인덱스 값에 해당하는 list를 찾아 삭제처리.
		for (int i = 0; i < list.size(); i++) {
			AccountDto dto = list.get(i);
			if(date.equals(dto.getDate()) && use.equals(dto.getUse())) {
				list.remove(i);
				index = i;
			}
			}if(index == -1) {
				System.out.println("삭제할 항목이 없습니다.");
			
		}
		

		
	}
	
		
	public void selectMonth() {
		// 연도월별 결산
		int sum = 0; // 모든 지출 금액
		int plus = 0; // 모든 수입 금액
		
		while(true) {
			
			// 연도는 연도만 출력하므로 연도만 입력받지만, 월의 경우 2022년 1월일수도, 2023년 1월일수도 있기에 년도를 입력받고 월을 입력 받는다.
			System.out.print("년도별 확인은 1번, 월별 확인은 2번을 눌러주세요: ");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.print("확인하고 싶은 년도를 입력하세요 :");
				int year = sc.nextInt(); // 우리는 값을 저장할 때 year, month를 따로 저장해뒀기 때문에 이때 사용이 가능하다.
				for (int i = 0; i < list.size(); i++) {
					AccountDto dto = list.get(i);
					if(year == dto.getYear()) {
						System.out.println(dto.toString()); // 해당 년도에 해당하는 가계부를 모두 출력한다. 
						if(dto.getClassify().equals("지출")) // classify 가 지출에 해당하면 sum에 담고, 지출이 아닌 경우(수입)에는 plus에 담는다.
							sum += dto.getMoney();
						else {
							plus += dto.getMoney();
						}
					}
				}
				System.out.println(year + "년에 사용한 금액은 : " + sum + "원, 벌어들인 금액은 : " + plus +"원 입니다.");
				break;
				
			}else if(num == 2) {
				System.out.print("확인하고 싶은 년을 입력하세요 :"); // 우리는 값을 저장할 때 year, month를 따로 저장해뒀기 때문에 이때 사용이 가능하다.
				int year = sc.nextInt();
				System.out.print("확인하고 싶은 월을 입력하세요 :");
				int month = sc.nextInt();
				for (int i = 0; i < list.size(); i++) {
					AccountDto dto = list.get(i);
					if(year==(dto.getYear()) && month == (dto.getMonth())) { // year과 month가 입력한 값과 모두 일치 하는 경우만
						System.out.println(dto.toString());
						if(dto.getClassify().equals("지출"))
						sum += dto.getMoney();
						else {
							plus += dto.getMoney();
						}
					}
				}
				System.out.println(year + "년 " + month + "월에 사용한 금액은 : " + sum + "원, 벌어들인 금액은 : " + plus +"원 입니다.");
				break;
				
			}else {
				System.out.println("다시 입력하세요.");
			}
		}
		
		
	}
		
		
	public void useMoney() {
		System.out.print("수입/지출 중 확인을 원하는 항목을 입력하세요 >> ");
		String usemoney = sc.next();
	
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			AccountDto dto = list.get(i);
			if(usemoney.equals(dto.getClassify())) {
				System.out.println(dto.toString());
				index = i;
				}
			}
		if(index == -1) {
			System.out.println("확인 할 항목이 없습니다");
		}
			
		
			
		}
		
		
		
		
	
		
	public void select() {	
		// 용도
		
		System.out.print("가계부 확인을 원하는 용도를 입력하세요 >>");
		String use = sc.next();
	
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			AccountDto dto = list.get(i);
			if(use.equals(dto.getUse())) {
				System.out.println(dto.toString());
				index = i;
				}
			}
		if(index == -1) {
			System.out.println("확인 할 항목이 없습니다");
		}
			
	}
	
	public void allprint() {
		for (AccountDto dto : list) {
			System.out.println(dto.toString());
		} 
	}
	
}
