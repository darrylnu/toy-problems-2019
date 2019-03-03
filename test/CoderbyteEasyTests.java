import org.testng.annotations.Test;

@Test
public class CoderbyteEasyTests {

    public void testFirstFactorial() {
        int input = 4;
        int output = CoderbyteEasy.firstFactorial(input);
        assert(output == 24);
    }

}
