class Solution {
	public int numSquares(int n) {
		List<Integer> q = new ArrayList<>();
		int len = (int)Math.sqrt(n);
		int[] l = new int[len]; 
		for (int i = 1; i <= len; i++) {
			l[i - 1] = i * i;
		}
		int cnt = 0;
		q.add(n);
		while(q.size() > 0) {
			cnt += 1;
			List<Integer> tmp = new ArrayList<>();
			for (int cur : q) {
				for (int j = len - 1; j >= 0; j--) {
					int sq = l[j];
					if (cur == sq) {
						return cnt;
					} else if (cur > sq) {
						tmp.add(cur - sq);
					}
				}
			}
			q = tmp;
		}
		return cnt;
	}

	public int numSquares(int n) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		int i = 0;
		while (i * i <= n) {
			l.add(i * i);
			i++;
		}
		int len = l.size();
		int cnt = 0;
		q.add(n);
		while(q.size() > 0) {
			cnt += 1;
			Queue<Integer> tmp = new LinkedList<>();
			while(q.size() > 0) {
				int cur = q.poll();
				for (int j = len - 1; j >= 0; j--) {
					int sq = l.get(j);
					if (cur == sq) {
						return cnt;
					} else if (cur > sq) {
						tmp.add(cur - sq);
					}
				}
			}
			q = tmp;
		}
		return cnt;
	}
}

// The basic idea of this solution is a BSF search for 
// shortest path, take 12 as an example, 
//as shown below, the shortest path is 12-8-4-0:
def numSquares(self, n):
    if n < 2:
        return n
    lst = []
    i = 1
    while i * i <= n:
        lst.append( i * i )
        i += 1
    cnt = 0
    toCheck = {n}
    while toCheck:
        cnt += 1
        temp = set()
        for x in toCheck:
            for y in lst:
                if x == y:
                    return cnt
                if x < y:
                    break
                temp.add(x-y)
        toCheck = temp

    return cnt




















































