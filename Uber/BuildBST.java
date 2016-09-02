import java.util.*;

public class Solution {
	public TreeNode buildBST(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		//build BST
		Arrays.sort(nums);
		TreeNode root = buildBSTHelper(nums, 0, nums.length - 1);
		return root;
	}

	private TreeNode buildBSTHelper(int[] nums, int start, int end) {
		//Arrays.sort(nums);
		if(start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(nums, start, mid - 1);
		root.right = buildBST(nums, mid + 1, end);
		return root;
	}
}