import org.testng.annotations.Test;

@Test
public class LeetCodeEasyTests {

    public void reverseInteger() {
        int input = -123;
        int output = LeetCodeEasy.reverseInteger(input);
        assert(output == -321);
    }

}