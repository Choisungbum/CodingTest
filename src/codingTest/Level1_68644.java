package codingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Level1_68644 {
	public int[] solution(int[] numbers) {
		Set<Integer> setnum = new HashSet<>();
		int idx = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				setnum.add(numbers[i] + numbers[j]);
				idx++;
			}
		}
		
        int[] answer = setnum.stream().mapToInt(i -> i).sorted().toArray();
        return answer ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_68644 cls = new Level1_68644();
		int[] arr = {2, 1, 3, 4, 1 };
		int[] arr2 = {5, 0, 2, 7};
		int[] arr3 = {1, 1, 1, 2};
		int[] ans = cls.solution(arr3);
		Arrays.stream(ans).forEach(System.out::println);
		
		

	}

}
