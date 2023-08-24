package codingTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Level1_42840 {
	 public int[] solution(int[] answers) {
		 
		 int[] answer = {};
		 int[] temp = new int[3];
		 // 1 번 수포자
        int[] first = {1, 2, 3, 4, 5};
        int result1 = comp(first,answers);
        // 2 번 수포자 
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int result2 = comp(second,answers);
        // 3 번 수포자 
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int result3 = comp(third,answers);
        temp[0] = result1;
        temp[1] = result2;
        temp[2] = result3;
        
        int max = result1;
        if (max < result2) max = result2;
        if (max < result3) max = result3;
        
        final int ans = max;
        
        return IntStream.range(0, 3)
        		.filter(i -> temp[i] == ans)
        		.map(i -> i + 1)
        		.toArray();
    }
	 
	 private int comp(int[] person, int[] answers) {
		 int resize = 0;
		 int cnt = 0;
		 for (int i = 0; i < answers.length; i++) {
    		resize = i % person.length;
    		if (answers[i] == person[resize]) {
        		cnt++;
    		}
        }
		 return cnt;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_42840 cls = new Level1_42840();
		int[] ans = cls.solution(new int[] {1,3,2,4,2});
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}

}
