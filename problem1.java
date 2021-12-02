import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while (sc.hasNext()) {
			list.add(sc.nextInt());
		}
		
		int result = 0;
		
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > list.get(i-1)) {
				result++;
			}
		}
		
		System.out.println(result);
		
		int window_size = 3;
		int window_sum = 0;
		for (int i = 0; i < window_size && i < list.size(); i++) {
			window_sum += list.get(i);
		}
		
		int start = 0, end = window_size-1;
		result = 0;
		while (start < list.size()) {
			int current_window_sum = window_sum;
			int next_window_sum = current_window_sum - list.get(start) + (end+1 < list.size() ? list.get(end+1): 0);
			if (next_window_sum > current_window_sum) result++;
			window_sum = next_window_sum;
			start++;
			end++;
		}
		System.out.println(result);
	}
}
