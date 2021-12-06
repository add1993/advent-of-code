/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String numList = sc.nextLine();
		int idx = 0;
		List<HashMap<Integer, Integer>> list = new ArrayList<>();
		HashMap<Integer, Integer> mm = new HashMap<>();
		
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.equals("")) continue;
			if (idx == 5) {
				list.add(mm);
				mm = new HashMap<>();
				idx = 0;
			}
			
			String[] nums = line.split(" ");
			int len = nums.length;
			int j = 0;
			for (int i = 0; i < len; i++) {
				if (nums[i].equals("")) continue;
				mm.put(Integer.parseInt(nums[i]), idx*5 + j++);
			}
			idx++;
		}

		String [] nums = numList.split(",");
		int [][][] bingo_arr = new int[list.size()][2][5];
		int flag = 0;
		System.out.println(list.size());
		System.out.println(list.get(0).size());
		boolean winners[] = new boolean[list.size()];
		for (int i = 0; i < nums.length; i++) {
			int num = Integer.parseInt(nums[i]);
			for (int j = 0; j < list.size(); j++) {
				if (winners[j] == true) continue;
				HashMap<Integer, Integer> tmap = list.get(j);
				if (tmap.containsKey(num)) {
					int index = tmap.get(num);
					int row = index/5;
					int col = index%5;
					bingo_arr[j][0][row]++;
					bingo_arr[j][1][col]++;
					tmap.remove(num);
					if (bingo_arr[j][0][row] == 5 || bingo_arr[j][1][col] == 5) {
						int sum = 0;
						for (Map.Entry<Integer, Integer> entry : tmap.entrySet()) {
							sum += entry.getKey();
						}
						System.out.println(sum * num);
						System.out.println("Winner board is " + j);
						System.out.println("Last num is " + num);
						winners[j] = true;
					}
				}
				list.set(j, tmap);
			}
		}
		
	}
}
