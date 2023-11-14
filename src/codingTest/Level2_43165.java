package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Level2_43165 {
	private static class State {
		public final int index;
		public final int acc;
		
		public State (int index, int acc) {
			this.index = index;
			this.acc = acc;
		}
	}
	
	public int solution(int[] numbers, int target) {
		Stack<State> s = new Stack<>();
		s.push(new State(0, 0));
		int count = 0;
		
		while(!s.isEmpty()) {
			State state = s.pop();
			
			if (state.index == numbers.length) {
				if (state.acc == target) count++;
				continue;
			}
			
			// + 를 선택한 경우
			s.push(new State(state.index + 1, state.acc + numbers[state.index]));
			// - 를 선택한 경우
			s.push(new State(state.index + 1, state.acc - numbers[state.index]));
		}
		
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers1 = new int[] {1, 1, 1, 1, 1};
		int target1 = 3;
		Level2_43165 cls = new Level2_43165();
		System.out.println(cls.solution(numbers1, target1));
	}

}
