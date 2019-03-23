public class LeetCodeEasy {

    /* Reverse Integer: Given a 32-bit signed integer, reverse digits of an integer.
    Example 1:
    Input: 123
    Output: 321 */
    static int reverseInteger(int num) {
        String numAsString = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean hasNegative = false;
        if(numAsString.charAt(numAsString.length() - 1) != '0') {
            sb.append(numAsString.charAt(numAsString.length() - 1));
        }
        if(numAsString.length() > 1) {
            for(int i = numAsString.length() - 2; i >= 0; i--) {
                if(numAsString.charAt(i) != '-') {
                    sb.append(numAsString.charAt(i));
                } else {
                    hasNegative = true;
                }
            }
        }
        if(hasNegative) {
            sb.insert(0, '-');
        }
        return Integer.parseInt(sb.toString());
    }

    /*Palindrome Number: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true*/


    /*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
*/

    /*Valid Parenthenses - Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true*/

    /*Merge Two Sorted Lists - Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
}
