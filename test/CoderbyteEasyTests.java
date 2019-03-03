import org.testng.annotations.Test;

@Test
public class CoderbyteEasyTests {

    public void testFirstFactorial() {
        int input = 4;
        int output = CoderbyteEasy.firstFactorial(input);
        assert(output == 24);
    }

    public void testLongestWord() {
        String input = "I want to go home";
        String output = CoderbyteEasy.longestWord(input);
        assert(output.equals("want"));
    }

}
