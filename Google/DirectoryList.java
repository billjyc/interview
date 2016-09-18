import java.util.*;

public class DirectoryList {
	public int directoryList(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int ans = 0;
		String[] filesAndDirs = s.split("\n");
		Stack<String> stack = new Stack<>();
		int curSpaceLen = 0;
		stack.push(filesAndDirs[0]);
		int length = filesAndDirs[0].length();
		for(int i = 1; i < filesAndDirs.length && !stack.isEmpty(); i++) {
			int num = numOfSpace(filesAndDirs[i]);
			while(!stack.isEmpty() && numOfSpace(stack.peek()) >= num) {
				String str = stack.pop();
				length -= (str.length() + 1);
			}
			stack.push(filesAndDirs[i]);
			length += (filesAndDirs[i].length() + 1);
			if(filesAndDirs[i].endWith("jpeg") || filesAndDirs.endWith("gif")) {
				ans += length;
			}
		}
		return ans % 1000000007;
	}

	private int numOfSpace(String str) {
		if(str.equals("")) return 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == " ") {
				return i;
			}
		}
		return str.length();
	}
}