/**
	given a array and a number max, find a list of Integer which is combined with 
	the numbers in the list and less than max, each number could be used for any times
	e.g. [1,2,3], max=130, return [1,2,3,11,12,13,21,22,23,31,32,33,111,112,113,121,122,123]
*/

public class Solution {
	public List<Integer> numbersCombination(int[] nums, int max) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		//boolean[] visited = new boolean[nums.length];
		dfs(result, 0, max, nums);

		return result;
	}

	public void dfs(List<Integer> result, int temp, int max
		, int[] nums) {
		if(temp > max) {
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			int x = temp * 10 + nums[i];
			if(x <= max) {
				result.add(x);
				dfs(result, x, max, nums);
			}
		}
	}
}