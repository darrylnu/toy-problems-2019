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

    public void removeDuplicates() {
        int[] input = {1,1,1,2,2,4,4,5};
        int output = LeetCodeEasy.removeDuplicates(input);
        assert(output == 4);
    }

    public void removeElement() {
        int[] input = {1,3,4,1,6,7,1,5};
        int output = LeetCodeEasy.removeElement(input, 1);
        assert(output == 5);
    }

    public void strStr() {
        String[] input = {"hello", "ll"};
        int output = LeetCodeEasy.strStr(input[0], input[1]);
        assert(output == 2);
    }

    public void searchInsertPosition() {
        int[] inputArray = {1,2,4,6,7};
        int output = LeetCodeEasy.searchInsertPosition(inputArray, 3);
        assert(output == 2);
    }

    public void lengthOfLastWord() {
        String input = "Hello World";
        int output = LeetCodeEasy.lengthOfLastWord(input);
        assert(output == 5);
    }

    public void plusOne() {
        int[] input = {4,3,2,1};
        int[] output = LeetCodeEasy.plusOne(input);
        assert(output[0] == 4);
        assert(output[1] == 3);
        assert(output[2] == 2);
        assert(output[3] == 2);
    }

}
