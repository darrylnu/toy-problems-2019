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

    public void firstReverse() {
        String input = "Hello World and Coders";
        String output = CoderbyteEasy.firstReverse(input);
        assert(output.equals("sredoC dna dlroW olleH"));
    }

    public void letterChanges() {
        String input = "hello*3";
        String output = CoderbyteEasy.letterChanges(input);
        assert(output.equals("Ifmmp*3"));
    }

    public void simpleAdding() {
        int input = 4;
        int output = CoderbyteEasy.simpleAdding(input);
        assert(output == 10);
    }
}
