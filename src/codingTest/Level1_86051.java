package codingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Level1_86051 {
	public int solution(int[] numbers) {
		Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		Set<Integer> setNumbers = new HashSet<>(Arrays.asList(nums));
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			if (!setNumbers.contains(i)) {
				System.out.println("i : " + ans);
				ans = ans + i;
			}
		}
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers1 = new int[] {1, 2, 3, 4, 6, 7, 8, 0};
		int[] numbers2 = new int[] {5, 8, 4, 0, 6, 7, 9};
		Level1_86051 cls = new Level1_86051();
		System.out.println(cls.solution(numbers2));
	}

}
