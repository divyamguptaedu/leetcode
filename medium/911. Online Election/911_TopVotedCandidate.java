"
Performance:
Runtime: 88 ms, faster than 92.87% of Java online submissions for Online Election.
Memory Usage: 86.9 MB, less than 85.41% of Java online submissions for Online Election.
"

class TopVotedCandidate {
    int[] result;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        result = new int[persons.length];
        this.times = new int[times.length];
        this.times = times;
        int[] list = new int[persons.length];  
        int max = -1;
        
        for (int i = 0; i < times.length; i++) {
            int temp = list[persons[i]]++;
            result[i] = (max <= temp) ? persons[i] : result[i - 1];
            max = (max <= temp) ? temp : max;
        }
    }
    
    public int q (int t) {
        int left = 1;
        int right = times.length;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (times[middle] <= t) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return result[left - 1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */