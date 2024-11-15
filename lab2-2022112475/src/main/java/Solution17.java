import java.util.*;

class Solution {
    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n < L) {
            return ans;
        }

        // 初始化哈希值
        long x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }

        // 用于存储哈希值的出现次数
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(x, 1);

        // 从第L个字符开始，每次向右移动一个字符
        for (int i = L - 1; i < n; ++i) {
            // 将前一个字符移出哈希值，并加入新字符
            x = (((x << 2) | bin.get(s.charAt(i))) & ((1L << (L * 2)) - 1)) | bin.get(s.charAt(i - (L - 1)));
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i - L + 1, i + 1));
            }
        }

        return ans;
    }
}