import HelperObjects.ListNode;
import com.sun.tools.javac.util.StringUtils;

import java.util.Collections;
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

    /*Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.*/
    static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int length = 1;
        int current = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == current) {
                continue;
            }
            length++;
            current = nums[i];
        }
        return length;
    }

    /*Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.*/

    static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int b = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[b] = nums[j];
                b++;
            }
        }
        return b;
    }

    /*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1*/
    static int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) {
            return -1;
        }
        if(haystack.isEmpty()) {
            return 0;
        }
        return StringUtils.indexOfIgnoreCase(haystack, needle);
    }

    /*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4*/
    static int searchInsertPosition(int[] sortedIntArray, int num) {
        for(int i = 0; i < sortedIntArray.length; i++) {
            if(sortedIntArray[i] == num) {
                return i;
            }
            if(i < sortedIntArray.length - 1 && num > sortedIntArray[i] && num < sortedIntArray[i + 1]) {
                return i + 1;
            }
        }
        return sortedIntArray.length;
    }

    /*The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"*/

    /*Maximum SubArray - Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.*/

    /*Length of Last Word - Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
    return the length of
    last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/
    static int lengthOfLastWord(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        String[] splitWords = str.split(" ");
        return splitWords[splitWords.length-1].length();
    }

    /*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/
    static int[] plusOne(int[] numArray) {
        if(numArray[0] == 0) {
            numArray[0] = 1;
            return numArray;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numArray.length; i++) {
            sb.append(numArray[i]);
        }
        Integer strAsNumPlusOne = Integer.parseInt(sb.toString()) + 1;
        String sumStr = strAsNumPlusOne.toString();
        String[] outputStr = sumStr.split("");
        int[] outputArr = new int[outputStr.length];
        for(int j = 0; j < outputStr.length; j++) {
            outputArr[j] = Integer.parseInt(outputStr[j]);
        }
        return outputArr;
    }

    /*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/
}
