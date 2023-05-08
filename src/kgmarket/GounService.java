package kgmarket;

import java.util.Scanner;

public class GounService {

	CategoryDTO dto = new CategoryDTO();
	Scanner scan = new Scanner(System.in);

	// 금액입력
	public void inputMoney() throws InterruptedException {
		System.out.print("○: 지금 내 주머니 안에는 ");
		int money = scan.nextInt();
		System.out.println("원 이 있다.");
		Thread.sleep(1000);
		System.out.println("○: 엇,, 뒤통수가 따갑다..");
		Thread.sleep(1000);
		System.out.println("●: (툭툭) 친구야!!; 지금 혹시 얼마있어??");
		Thread.sleep(1000);
		System.out.println("○: 네..?");
		Thread.sleep(1000);
		System.out.println("●: 아니 나 마트 가야되는데 돈이 없어가주구ㅎ.");
		Thread.sleep(1000);
		while (true) {
			System.out.println("=================================================");
			System.out.println("1. ○: 아,, 저 돈 없어요,,");
			System.out.println("2. ○: 아,, 저 지금" + money + "원 있어요,,");
			System.out.print("대답을 선택해주세요 ->");
			int num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.println("●: 진짜로 없어?? 진짜루??ㅎㅎ^^");
				Thread.sleep(1000);
				System.out.println("○: 아,, 사실은,,");
				System.out.println();
				Thread.sleep(1000);
				break;
			case 2:
				System.out.println("●: 나 좀 빌릴게!! 진짜 고마워 친구야♥");
				System.out.println();
				return;
			}
		}
	}

}
