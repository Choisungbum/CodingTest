package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Level2_72411 {
	private static class Course{
		public final String course; // 코스
		public final int occurrences; //
		
		public Course(String course, int occurrences) {
			this.course = course;
			this.occurrences = occurrences;
		}
	}
	
	private void getCourses(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList, 
								Map<Integer, List<Course>> courses) {
		int occurrences= (int) orderList.stream()
										.filter(order -> order.containsAll(selectedMenus))
										.count();
		if (occurrences < 2) return;
		
		int size = selectedMenus.size();
		if(courses.containsKey(size)) {
			List<Course> courseList = courses.get(size);
			Course course = new Course(selectedMenus.stream()
													 .sorted()
													 .collect(Collectors.joining("")),
												 	occurrences);
			Course original = courseList.get(0);
			if(original.occurrences < occurrences) {
				courseList.clear();
				courseList.add(course);	
			} else if (original.occurrences == occurrences) {
				courseList.add(course);
			}
		}
		
		if (size >= 10) return;
		for(char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
	}
	public String[] solution(String[] orders, int[] course) {
		List<Set<String>> orderList = Arrays.stream(orders)
				.map(String::chars)
				.map(charStream -> charStream
					  .mapToObj(menu-> String.valueOf((char) menu))
					  .collect(Collectors.toSet())
		).collect(Collectors.toList());
		
		Map<Integer, List<Course>> courses = new HashMap<>();
		for(int length : course) {
			List<Course> list = new ArrayList<>();
			list.add(new Course("", 0));
			courses.put(length, list);
		}
		getCourses('A', new HashSet<>(), orderList, courses);
		
		
		return courses.values().stream()
				 .filter(list->list.get(0).occurrences > 0)
				 .flatMap(List::stream)
				 .map(c -> c.course)
				 .sorted()
				 .toArray(String[]::new);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ord = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] cor = new int[] {2, 3,4 };
		Level2_72411 cls = new Level2_72411();
//		System.out.println(cls.solution(ord, cor));
	}

}
