package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Level2_42746 {
		public String solution(int[] numbers) {
			return Arrays.stream(numbers).mapToObj(String::valueOf)
								  .sorted((s1, s2) -> {
									  int original = Integer.parseInt(s1 + s2);
									  int reverse  = Integer.parseInt(s2 + s1);
									  return reverse - original;
								  }).collect(Collectors.joining(""))
								  .replaceAll("^0+", "0");
			
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42746 cls = new Level2_42746();
		int[] arr = new int[] {6,10,2};
		int[] arr1 = new int[] {9, 5, 3, 30, 34};
		int[] arr2 = new int[] {11, 12, 9, 70, 28};
		int[] arr3 = new int[] {1,2,0};
		System.out.println(cls.solution(arr2));
	}

}

/*
 * import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

	public class Level2_42746 {
		private Set<String> getNum(String num, List<String> useNum, boolean[] isUsed,Set<String> makeNum){
			int cnt = 0;
			
			for(boolean b : isUsed) {
				if (b == true) cnt++;
			}
			
			if (cnt == isUsed.length) makeNum.add(num);
				
			for(int i = 0; i < useNum.size(); i++) {
				if(isUsed[i]) continue;
				
				StringBuilder sb = new StringBuilder(num);
				String nextNum = sb.append(useNum.get(i)).toString();
				isUsed[i] = true;
				makeNum.addAll(getNum(nextNum, useNum, isUsed, makeNum));
				isUsed[i] = false;
			}
			
			return makeNum;
		}
		public String solution(int[] numbers) {
			Set<String> makeNum = new HashSet<>();
			List<String> useNum =  Arrays.stream(numbers)
										.boxed()
								  		.map(c -> Integer.toString(c))
								  		.collect(Collectors.toList());
			
			 return getNum("", useNum, new boolean[useNum.size()] ,makeNum).stream()
									   .map(str -> Integer.parseInt(str))
									   .max((v1, v2) -> v1 - v2)
									   .orElse(1)
									   .toString();
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42746 cls = new Level2_42746();
		int[] arr = new int[] {6,10,2};
		System.out.println(cls.solution(arr));
	}

}

 * */

/*
 public String solution(int[] numbers) {
			List<String> sortStr = Arrays.stream(numbers).boxed()
								  .map(str -> Integer.toString(str))
								  .sorted((v1, v2) -> {
									  int size = v1.length() > v2.length() ? v1.length() : v2.length();
									  String v1tmp = "";
									  String v2tmp = "";
									  for(int i = 0; i <  size;i++) {
										 v1tmp = v1.length() > i ? v1.substring(i,i + 1) : v1.substring(0,1);
										 v2tmp = v2.length() > i ? v2.substring(i,i + 1) : v2.substring(0,1);
										 
										 if (v1tmp.compareTo(v2tmp) == 0) {
											 continue;
										 } else {
											 break;
										 }
									  }
									  return v2tmp.compareTo(v1tmp);
								  })
								  .collect(Collectors.toList());
			StringBuilder sb = new StringBuilder();
			for (String s : sortStr) {
				sb.append(s);
			} 
			String answer = Integer.toString(Integer.parseInt(sb.toString())); 
			return answer;
	    }
 * */
