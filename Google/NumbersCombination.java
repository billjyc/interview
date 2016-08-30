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