import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toUpperCase;

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

    /*Have the function LetterCapitalize(str) take the str parameter being passed and capitalize the first letter of each word. Words will be separated by only one space.*/
    static String letterCapitalize(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strArray = str.split(" ");
        for(int i = 0; i < strArray.length; i++) {
            StringBuilder wordSb = new StringBuilder();
            String firstLetter = Character.toString(toUpperCase(strArray[i].charAt(0)));
            wordSb.append(firstLetter);
            if(strArray[i].length() > 1) {
                for(int j = 1; j < strArray[i].length(); j++) {
                    wordSb.append(strArray[i].charAt(j));
                }
            }
            sb.append(wordSb.toString());
            if(!(i == strArray.length-1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /*Have the function SimpleSymbols(str) take the str parameter being passed and determine if it is an acceptable sequence by either returning the string true or false. The str parameter will be composed of + and = symbols with several letters between them (ie. ++d+===+c++==a) and for the string to be true each letter must be surrounded by a + symbol. So the string to the left would be false. The string will not be empty and will have at least one letter. */
    static boolean simpleSymbols(String str) {
        boolean valid = true;
        String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        if(alphabet.contains(Character.toString(str.charAt(0))) || alphabet.contains(Character.toString(str.charAt(str.length()-1)))) {
            return false;
        }
        for(int i =0; i < str.length(); i++) {
            if(alphabet.contains(Character.toString(str.charAt(i)).toLowerCase())) {
                if((str.charAt(i + 1) != '+') || (str.charAt(i - 1) != '+')) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    /*Have the function CheckNums(num1,num2) take both parameters being passed and return the string true if num2 is greater than num1, otherwise return the string false. If the parameter values are equal to each other then return the string -1.
     */
    static String checkNums(int num1, int num2) {
        if(num2 > num1) {
            return "true";
        } else if(num2 == num1) {
            return "-1";
        } else {
            return "false";
        }
    }

    /*Have the function TimeConvert(num) take the num parameter being passed and return the number of hours and minutes the parameter converts to (ie. if num = 63 then the output should be 1:3). Separate the number of hours and minutes with a colon.
     */
    static String timeConvert(int num) {
        final int oneHr = 60;
        int hourCount = 0;
        int leftOverMinutes = 0;
        while(num >= oneHr) {
            hourCount++;
            num -= 60;
        }
        if(num > 0) {
            leftOverMinutes = num;
        }
        return "" + hourCount + ":" + "" + leftOverMinutes;
    }

    /*Have the function AlphabetSoup(str) take the str string parameter being passed and return the string with the letters in alphabetical order (ie. hello becomes ehllo). Assume numbers and punctuation symbols will not be included in the string. */
}
