/**
	given a sequence of work, (e.g. ABAB), compute the total work time needed for the sequence
	There is a cooldown time if you do the same job

	e.g. a sequence ABAB, and coolDown = 3
	the work time is AB.AB = 5
	a sequence AABB, and cool down time = 5
	the work time is A....AB....B = 12
	a sequence AABB, and cool down time = 1
	the work time is AABB = 4
*/
public class CoolDown {
	public int solution(char[] works, int coolDown) {
		if(works == null || works.length == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int current = 0;
		for(int i = 0; i < works.length; i++) {
			char c = works[i];
			if(map.containsKey(c)) {
				int lastTime = map.get(c);
				if(current - lastTime < coolDown) {
					current = lastTime + coolDown;
				}
				map.put(c, current);
			} else {
				map.put(c, current);
			}
			current++;
		}
		return current;
	}
}