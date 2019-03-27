import org.testng.annotations.Test;

@Test
public class LeetCodeEasyTests {

    public void reverseInteger() {
        int input = -123;
        int output = LeetCodeEasy.reverseInteger(input);
        assert(output == -321);
    }

    public void palindromeInteger() {
        int input = 121;
        boolean output = LeetCodeEasy.palindromeNumber(input);
        assert(output);
    }

    public void commonPrefix() {
        String[] input = {"flight", "flag", "flee"};
        String output = LeetCodeEasy.commonPrefix(input);
        assert(output.equals("fl"));
    }

}
