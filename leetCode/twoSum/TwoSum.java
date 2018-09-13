package leetCode.twoSum;

import java.util.*;

class Solution {
	public int[] twoSumSolution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSumSolution2(int[] nums, int target) {
		ArrayList<Integer> numsList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			numsList.add(target - nums[i]);

		for (int indexArray = 0; indexArray < nums.length; indexArray++) {
			int indexList = numsList.indexOf(nums[indexArray]);
			if (indexList > -1 && indexList != indexArray)
				return (indexList < indexArray) ? new int[] { indexList, indexArray }
						: new int[] { indexList, indexArray };
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSumSolution3(int[] nums, int target) {
		HashMap<Integer, Integer> LeftMap = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (LeftMap.containsKey(nums[i])) {
				int indexLeft = LeftMap.get(nums[i]);
				return new int[] { indexLeft, i };
			} else {
				LeftMap.put(target - nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
