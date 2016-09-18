public class Solution {
	public int distanceBetweenTwoNodes(TreeNode n1, TreeNode n2, TreeNode root) {
		if(n1 == null || n2 == null || n1 == n2) {
			return 0;
		}
		//find lowest common ancestor
		TreeNode lca = findLCA(n1, n2, root);
		int dis1 = helper(n1, ancestor);
		int dis2 = helper(n2, ancestor);
		return dis1 + dis2;
	}

	private int helper(TreeNode node, TreeNode ancestor) {
		if(ancestor == null) {
			return -1;
		}
		if(node == ancestor) {
			return 0;
		}

		int left = helper(node, ancestor.left);
		int right = helper(node, ancestor.right);
		if(right != -1) return right + 1;
		if(left != -1) return left + 1;
		return -1;
	}

	private TreeNode findLCA(TreeNode n1, TreeNode n2, TreeNode root) {
		if(root == null) return null;
		if(root == n1 || root == n2) {
			return root;
		}
		TreeNode left = (n1, n2, root.left);
		TreeNode right = (n1, n2, root.right);
		if(left != null && right != null) {
			return root;
		}
		if(left != null) return left;
		if(right != null) return right;
		return null;
	}
}