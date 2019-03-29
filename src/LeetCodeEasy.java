import HelperObjects.ListNode;
import com.sun.tools.javac.util.StringUtils;

import java.util.LinkedList;
import java.util.Stack;

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
    static boolean palindromeNumber(int num) {
        String numAsStr = Integer.toString(num);
        StringBuilder reversedStr = new StringBuilder();
        for(int i = numAsStr.length() - 1; i >= 0; i--) {
            reversedStr.append(numAsStr.charAt(i));
        }
        if(reversedStr.toString().equals(numAsStr)) {
            return true;
        }
        return false;
    }


    /*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
*/
    static String commonPrefix(String[] strings) {
        boolean lettersMatch = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strings[0].length();i++) {
            char currentCharacter = strings[0].charAt(i);
            for(int j = 1; j < strings.length;j++) {
                try {
                    if(currentCharacter != strings[j].charAt(i)) {
                        lettersMatch = false;
                        break;
                    }
                } catch (Exception e) {
                    lettersMatch = false;
                    break;
                }
            }
            if(lettersMatch) {
                sb.append(currentCharacter);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /*Valid Parenthenses - Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true*/

    static boolean validParentheses(String str) {
        if(str.equals("")) return true;
        Stack<String> letterStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if( i == 0) {
                letterStack.push(Character.toString(str.charAt(i)));
            } else if(letterStack.lastElement().equals("{") && Character.toString(str.charAt(i)).equals("}")) {
                letterStack.pop();
            } else if(letterStack.lastElement().equals("(") && Character.toString(str.charAt(i)).equals(")")) {
                letterStack.pop();
            } else if(letterStack.lastElement().equals("[") && Character.toString(str.charAt(i)).equals("]")) {
                letterStack.pop();
            } else {
                letterStack.push(Character.toString(str.charAt(i)));
            }
        }
        return letterStack.isEmpty() ? true : false;
    }

    /*Merge Two Sorted Lists - Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
    static ListNode mergeTwoLinkedLists(ListNode node1, ListNode node2) {
        if(node1 == null) {
            return node2;
        }
        if(node2 == null) {
            return node1;
        }
        ListNode result = null;
        ListNode head = null;
        ListNode currentNode;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                currentNode = new ListNode(node1.val);
                node1 = node1.next;
            } else if(node2.val < node1.val) {
                currentNode = new ListNode(node2.val);
                node2 = node2.next;
            } else {
                currentNode = new ListNode(node1.val);
                currentNode.next = new ListNode(node2.val);
                node1 = node1.next;
                node2 = node2.next;
            }
            if(head == null) {
                result = currentNode;
                head = result;
            } else {
                ListNode currentResultTail = result;
                while (result.next != null) {
                    currentResultTail = result.next;
                    result = result.next;
                }
                currentResultTail.next = new ListNode(currentNode.val);
                result = currentResultTail.next;
            }
        }
        while(node1 != null) {
            result.next = new ListNode(node1.val);
            result = result.next;
            node1 = node1.next;
        }
        while(node2 != null) {
            result.next = new ListNode(node2.val);
            result = result.next;
            node2 = node2.next;
        }
        return head;
    }
}
