package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_42883 {

	
	 public String solution(String number, int k) {
		 // 1. 첫 번째 숫자를 구할 수 있는 범위지정 (number.length() - k + 1)
		 String maxStr = number.substring(0, number.length() - k + 1);
		 String lastStr = number.substring(number.length() - k + 1);
		 System.out.println("lastStr : " + lastStr);
		 System.out.println("maxStr : " + maxStr);
		 
		 // 2. 해당 범위서 가장 큰 숫자 서택 
		 //    중복 시 제일 앞에 있는 숫자 선택
		 int index = 0;
		 for (int i = 9; i > -1; i--) {
			 if (maxStr.indexOf(String.valueOf(i)) > -1) {
				 String firstStr = String.valueOf(i);
				 System.out.println("firstStr : " + firstStr);
				 index = maxStr.indexOf(String.valueOf(i));
				 break;
			 }
		 }
		 
		 
		 // 3 - 1. 해당 index 기점으로 빼야될 숫자 범위 구함
		 String deleteStr = maxStr.substring(index + 1);
		 System.out.println("deleteStr : " + deleteStr);
		 System.out.println("index : " + index);
		 // 3 - 2. 해당 index 기점으로 빼야될 문자수 다시 구함
		 k = k - index;
		 char[] sortStr = deleteStr.toCharArray();
		 Arrays.sort(sortStr);
		 
		 for (int i = 0; i < k; i++) {
			 deleteStr.replace(String.valueOf(sortStr[i]), "");
		 }
		 
		 
		 
		 return deleteStr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42883 cls = new Level2_42883();
		String number = "1924";
		int k = 2;
		
		String number1 = "1231234";
		int k1 = 3;
		
		String number2 = "4177252841";
		int k2 = 4;
		
		System.out.println("result : " + cls.solution(number1, k1));

	}

}
