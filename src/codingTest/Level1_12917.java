	package codingTest;

import java.util.Arrays;
import java.util.stream.Stream;

public class Level1_12917 {
	 public String solution(String s) {
		 return s.chars().boxed()
		 			 .sorted((v1, v2) -> v2 - v1)
		 			 .collect(StringBuilder::new,
		 					  StringBuilder::appendCodePoint,
		 			 		  StringBuilder::append).toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_12917 cls = new Level1_12917();
		System.out.println(cls.solution("Zbcdefg"));
	}

}
