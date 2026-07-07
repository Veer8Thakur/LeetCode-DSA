class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int left = 0;
        int write = 0;

        while (left < n) {
            int right = left;

            while (right < n && chars[right] == chars[left]) {
                right++;
            }

            int len = right - left;

            chars[write++] = chars[left];

            if (len > 1) {
                String freq = String.valueOf(len);

                for (char ch : freq.toCharArray()) {
                    chars[write++] = ch;
                }
            }
            left = right;
        }
        return write;
    }
}