import java.util.HashMap;
import java.util.Map;

public class CoderbyteEasy {

    /*Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it. For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. For the test cases, the range will be between 1 and 18 and the input will always be an integer. */
    static int firstFactorial(int num) {
        int total = num;
        for(int i = num -1; i >=1; i--) {
            total = total * i;
        }
        return total;
    }

    /*Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string. If there are two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume sen will not be empty.
     */
    static String longestWord(String sen) {
        String[] arrayOfStr = sen.split(" ");
        Map<String, Integer> highCountMap = new HashMap<>();
        highCountMap.put(arrayOfStr[0], arrayOfStr[0].length());
        for(int i = 1; i < arrayOfStr.length; i++) {
            if(arrayOfStr[i].length() > highCountMap.values().stream().findFirst().get()) {
                highCountMap.remove(highCountMap.keySet().stream().findFirst().get());
                highCountMap.put(arrayOfStr[i], arrayOfStr.length);
            }
        }
        return highCountMap.keySet().stream().findFirst().get();
    }

    /*Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order. For example: if the input string is "Hello World and Coders" then your program should return the string sredoC dna dlroW olleH.
     */
    static String  firstReverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    /*Have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm. Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a). Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
     */
    static String letterChanges(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            sb.append(getFollowingLetter("" + str.charAt(i)));
        }
        return sb.toString();
    }

    private static String getFollowingLetter(String str) {
        String alphabetStr = "A b c d E f g h I j k l m n O p q r s t U v w x y z a";
        String[] alphabetArray = alphabetStr.split(" ");
        for(int i = 0; i < alphabetArray.length; i++) {
            if (alphabetArray[i].equalsIgnoreCase(str)) {
                return alphabetArray[i + 1];
            }
        }
        return str;
    }

    /*Have the function SimpleAdding(num) add up all the numbers from 1 to num. For example: if the input is 4 then your program should return 10 because 1 + 2 + 3 + 4 = 10. For the test cases, the parameter num will be any number from 1 to 1000. */
    static int simpleAdding(int num) {
        int total = num;
        for(int i = num - 1; i >=0; i--) {
            total += i;
        }
        return total;
    }
}
