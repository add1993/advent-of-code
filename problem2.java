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
		int[][] dirs = {{1, 0}, {0, -1}, {0, 1}};
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			if (split[0].equals("forward")) {
				list1.add(0);
			} else if (split[0].equals("down")) {
				list1.add(1);
			} else {
				list1.add(2);
			}
			list2.add(Integer.parseInt(split[1]));
		}
		
		int x = 0, y = 0;
		for (int i = 0; i < list1.size(); i++) {
			int idx = list1.get(i);
			x += dirs[idx][0] * list2.get(i);
			y += dirs[idx][1] * list2.get(i);
		}
		
		System.out.println(x + "," + y);
	}
}

/* package whatever; // don't place package name! */

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
		int[][] dirs = {{1, 0}, {0, -1}, {0, 1}};
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			if (split[0].equals("forward")) {
				list1.add(0);
			} else if (split[0].equals("down")) {
				list1.add(1);
			} else {
				list1.add(2);
			}
			list2.add(Integer.parseInt(split[1]));
		}
		
		int x = 0, y = 0, aim = 0;
		for (int i = 0; i < list1.size(); i++) {
			int idx = list1.get(i);
			
			
			if (idx == 1) {
				aim += list2.get(i);
				continue;
			} else if (idx == 2) {
				aim -= list2.get(i);
				continue;
			}
			
			if (idx == 0) {
				x += dirs[idx][0] * list2.get(i);
				y += aim * list2.get(i);
			}
		}
		
		System.out.println(x + "," + y);
	}
}
