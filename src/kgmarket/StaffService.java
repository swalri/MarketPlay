package kgmarket;

import java.io.*;
import java.util.Scanner;

public class StaffService implements File_Path {
	Scanner scan = new Scanner(System.in);
	private File path;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;

	private FileInputStream fis;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	CategoryDTO dto = new CategoryDTO();

	// 생성
	public void inputcategory() throws Exception {
		System.out.println("등록하실 카테고리를 입력해주세요: ");
		String category = scan.next();
		path = new File(PATH + category);
		path.mkdir();

		System.out.println("등록하실 상품명을 입력해주세요: ");
		String product = scan.next();
		path = new File(PATH + category + "\\" + product + ".txt");
		fos = new FileOutputStream(path);
		bos = new BufferedOutputStream(fos);
		oos = new ObjectOutputStream(bos);

		System.out.println("등록하실 가격을 입력해주세요: ");
		int price = scan.nextInt();

		dto.setCategory(category);
		dto.setProduct(product);
		dto.setMoney(price);
		oos.writeObject(dto);

		oos.close();
		bos.close();
		fos.close();
	}

	// 중복확인
	public boolean checkUser(String name) {
		path = new File(PATH + name);
		return path.exists();// 파일이 있을경우 true
	}

	// 모든 카테고리 출력
	public void showAllCategory() {
		path = new File(PATH);
		String[] fileList = path.list();
		for (String file : fileList) {
			System.out.print(file + " ");
		}
		System.out.println();
	}

	// 모든 상품 출력
	public void showAllProduct(String s) throws Exception {
		path = new File(PATH + s);
		File[] fileList = path.listFiles();
		for (File file : fileList) {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			dto = (CategoryDTO) ois.readObject();
			System.out.print(dto.getProduct() + " ");
		}
		System.out.println();
	}

	// 카테고리 선택
	// 카테고리 안에 모든 상품 출력
	public void choiceCategory() throws Exception {
		String categoryName;
		String productName;

		showAllCategory();// 전체폴더 출력

		System.out.println("카테고리를 입력해주세요 ");
		categoryName = scan.next();// 카테고리 선택
		if (checkUser(categoryName) == false) {
			System.out.println("존재하지 않는 파일입니다");
		}else {
			showAllProduct(categoryName);// 카테고리 안에 모든 상품 이름

			System.out.print("상품명 : ");
			productName = scan.next();// 상품 선택
			productName += ".txt";
			if(checkUser(categoryName+"\\"+productName) == false) {
				System.out.println("존재하지 않는 파일입니다");
			}else {
				path = new File(PATH + categoryName + "\\" + productName);	
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				dto = (CategoryDTO) ois.readObject();
				System.out.println(dto.getProduct() + " : " + dto.getMoney());
				ois.close();
				bis.close();
				fis.close();
			}//else
		}//else
	}// choiceCategory
}

