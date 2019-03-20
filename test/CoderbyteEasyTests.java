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

    public void letterCapitalize() {
        String input = "i like to go fishing.";
        String output = CoderbyteEasy.letterCapitalize(input);
        assert(output.equals("I Like To Go Fishing."));
    }

    public void simpleSymbols() {
        String input = "+d+=3=+s+";
        boolean output = CoderbyteEasy.simpleSymbols(input);
        assert(output);

        String input2 = "f++d+";
        boolean output2 = CoderbyteEasy.simpleSymbols(input2);
        assert(!output2);
    }

    public void checkNums() {
        int input1 = 4;
        int input2 = 8;
        String output = CoderbyteEasy.checkNums(input1, input2);
        assert(output.equals("true"));
    }
}
