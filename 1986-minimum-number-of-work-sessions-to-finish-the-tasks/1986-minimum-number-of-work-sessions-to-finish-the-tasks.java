
class Solution {
    private int min;
    public int minSessions(int[] tasks, int sessionTime) {
        this.min = tasks.length;
        int[] sessions = new int[min];
        Arrays.fill(sessions, sessionTime);
        backtrack(tasks, sessions, min - 1, 0);
        return min;
    }
    private void backtrack(int[] tasks, int[] sessions, int index, int sessionCount) {
        if(sessionCount >= min) return;
        if(index == -1) {
            min = sessionCount;
            return;
        }

        int val = tasks[index];
        for(int i = 0; i < sessionCount; i++) {
            if(sessions[i] >= val) {
                sessions[i] -= val;
                backtrack(tasks, sessions, index - 1, sessionCount);
                sessions[i] += val;
            }
        }

        sessions[sessionCount] -= val;
        backtrack(tasks, sessions, index - 1, sessionCount + 1);
        sessions[sessionCount] += val;
    }
}