package kgmarket;

import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int num;
		GounService gs = new GounService();//금액입력
		StaffService ss = new StaffService();
		
		while (true) {
										 
			System.out.println("1. 엄마 심부름을 하러 마트로 가고있다.");
			System.out.println("2. 아싸 마트 가야지~~"); //카테고리 등록->상품등록
			System.out.println("3. 상품선택"); //카테고리 선택->상품선택->가격보여줌->결제여부물어봄
			System.out.println("4. 종료"); 
			System.out.print(">>> ");
			num = scan.nextInt();
			switch (num) {
			case 1:
				gs.inputMoney();
				break;
			case 2:
				ss.inputcategory();
				break;
			case 3:
				ss.choiceCategory();
				break;
			case 4:
				System.out.println("종료");
				System.exit(0);
				break;
			}
		}

	}

}
