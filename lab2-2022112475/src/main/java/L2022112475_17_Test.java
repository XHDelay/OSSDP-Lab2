import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 测试类L2022112475_17_Test
 * 测试用例设计原则：
 * 1. 等价类划分
 *    a. 字符串长度小于10，无重复子串。
 *    b. 长度为10，存在一个重复子串。
 *    c. 长度大于10，包含多个重复子串。
 *    d. 长度大于10，但无重复子串。
 * 2. 边界测试
 *    a. 空字符串输入。
 */
public class L2022112475_17_Test {

    /**
     * 测试用例1：
     * 输入字符串长度小于10，测试预期返回空列表
     */
    @Test
    public void testShorterThan10() {
        Solution solution = new Solution();
        List<String> result = solution.findRepeatedDnaSequences("ACGTACGT");
        Assertions.assertEquals(List.of(), result);
    }

    /**
     * 测试用例2：
     * 输入字符串长度为10，测试预期返回一个重复子串
     */
    @Test
    public void testEqualTo10() {
        Solution solution = new Solution();
        List<String> result = solution.findRepeatedDnaSequences("AAAAAAAAAA");
        Assertions.assertEquals(List.of("AAAAAAAAAA"), result);
    }

    /**
     * 测试用例3：
     * 输入包含多个重复子串，测试预期返回包含所有重复子串的列表
     */
    @Test
    public void testMultipleRepeats() {
        Solution solution = new Solution();
        List<String> result = solution.findRepeatedDnaSequences("AAAACCCCAAAACCCCGGGTTTCCCCAAAACCCCAAAA");
        Assertions.assertEquals(List.of("CCCCAAAACC", "CCCAAAACCC","CCAAAACCCC"), result);
    }

    /**
     * 测试用例4：
     * 输入包含不重复的子串，测试预期返回空列表
     */
    @Test
    public void testNoRepeats() {
        Solution solution = new Solution();
        List<String> result = solution.findRepeatedDnaSequences("ACGTACGTACGTACGTACGT");
        Assertions.assertEquals(List.of(), result);
    }

    /**
     * 测试用例5：
     * 输入空字符串，测试预期返回空列表
     */
    @Test
    public void testEmptyString() {
        Solution solution = new Solution();
        List<String> result = solution.findRepeatedDnaSequences("");
        Assertions.assertEquals(List.of(), result);
    }
}
