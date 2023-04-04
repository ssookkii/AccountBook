package main;

import java.util.Scanner;
import dao.AccountDao;


public class MainClass {

	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		
					
		
		//menu
		Scanner sc = new Scanner(System.in);
			out:while(true) {
					
				System.out.println(" << 주소록 >> ");
				System.out.println("1. 가계부 입력");
				System.out.println("2. 가계부 삭제");
				System.out.println("3. 년/월 데이터 보기");
				System.out.println("4. 수입/지출 보기");
				System.out.println("5. 용도별 보기");
				System.out.println("6. 가계부 전체 보기");
				System.out.println("7. 종료....");
					
				
				System.out.print(">> ");
				
				int choice = sc.nextInt();
					
				switch(choice) {
					case 1:
						dao.insert();
						break;
					case 2:
						dao.delete();
						break;
					case 3:
						dao.selectMonth();
						break;
					case 4:
						dao.useMoney();
						break;
					case 5:
						dao.select();
						break;
					case 6:
						dao.allprint();
						break;
					case 7:	
						break out;
					default:
							
					}
			}
	}
}


	
		
