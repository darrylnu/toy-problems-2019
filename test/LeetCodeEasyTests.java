import HelperObjects.ListNode;
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

    public void validParentheses() {
        String input = "[{}]";
        boolean output = LeetCodeEasy.validParentheses(input);
        assert(output);
    }

    public void mergeTwoLinkedLists() {
        ListNode input1 = new ListNode(1);
        input1.next = new ListNode(2);
        input1.next.next = new ListNode(5);
        ListNode input2 = new ListNode(1);
        input2.next = new ListNode(3);
        input2.next.next = new ListNode(4);

        ListNode output = LeetCodeEasy.mergeTwoLinkedLists(input1, input2);
        assert(output.val == 1);
        assert(output.next.val == 1);
        assert(output.next.next.val == 2);
        assert(output.next.next.next.val == 3);
        assert(output.next.next.next.next.val == 4);
        assert(output.next.next.next.next.next.val == 5);




    }

}
