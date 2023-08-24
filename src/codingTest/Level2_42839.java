package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Level2_42839 {
	private Set<Integer> getPrimes(int acc, List<Integer> numbers) {
		Set<Integer> primes = new HashSet<>();
		if (isPrime(acc)) primes.add(acc);
		if (numbers.isEmpty()) return primes;
		
		for(int i = 0; i < numbers.size(); i++) {
			int nextAcc = acc * 10 + numbers.get(i);
			List<Integer> nextNumbers = new ArrayList<>(numbers);
			nextNumbers.remove(i);
			primes.addAll(getPrimes(nextAcc, nextNumbers));
		}
		return primes;
	}
	
	private boolean isPrime(int n) { // 소수검사 
		if(n <= 1) return false;
		for(int i = 2;i * i <= n;i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public int solution(String nums) {
		List<Integer> numbers = nums.chars()
									.map(c -> c - '0')
									.boxed()
									.collect(Collectors.toList());
        return getPrimes(0, numbers).size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "안녕하세요";
//		String[] strarr = str.split("");
//		for (int i = 0; i < strarr.length; i++) {
//			if(i == 2) strarr[i] = null;
//		}
//		for (int i = 0; i < strarr.length; i++) {
//			System.out.println("strarr["+i+"]" + strarr[i]);
//		}
//		for(char c : str.toCharArray()) {
//			System.out.println("str : " + c);
//		}
		
		Level2_42839 cls = new Level2_42839();
		cls.solution("123");
		
	}

}
/*
 private List<String> newStrlist(String num, String[] token, List<String> listStr) {
//		List<String> listStr = new ArrayList<>();
//		List<String> tmp = new ArrayList<>(token);
		 String[] copy = token.clone();
		listStr.add(num);
		
		if(token.length == 0) return listStr;
		
//		for (int i = 0; i < tmp.size(); i++) {
//			String newNum = num + token.get(i);
//			tmp.remove(i);
//			listStr.addAll(newStrlist(newNum, tmp, listStr));
//		}
		for (String s : token) {
			if ("".equals(s)) continue;
			
			listStr.addAll(newStrlist(num + s, token, listStr));
		}
		return listStr;
	}
 * 
 * */
