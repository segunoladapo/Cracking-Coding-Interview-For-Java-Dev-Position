package MSFT;

import static MSFT.MyAtoiApp.myAtoi;

public class ValidPalindrome {

    public static void main(String... args) {
        System.out.println(isValidPalindromeUsingPointer("AA   D   A"));
        System.out.println(myAtoi("-45000"));
        System.out.println(RevereString.reverse(new char[]{'h','e','l','l','o'}));
    }

    public static boolean isValidPalindromeUsingPointer(String input) {

        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            while (start > end && !isAlphaNum(input.charAt(start))) start++;
            while (start > end && !isAlphaNum(input.charAt(end))) end--;

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }


    public static boolean isValidPalindrome(String input) {
        StringBuffer buf = new StringBuffer();

        for (char c : input.toCharArray()) {
            if (isAlphaNum(c))
                buf.append(lowerCase(c));
        }
        String reversed;
        input = buf.toString();
        reversed = buf.reverse().toString();

        if (input.equals(reversed))
            return true;
        else
            return false;

    }

    static boolean isAlphaNum(char c) {
        if ((48 <= c && c <= 57) || (65 <= c && c <= 90) || (97 <= c && c <= 122))
            return true;
        else
            return false;
    }

    static char lowerCase(char c) {
        if (65 <= c && c <= 90)
            return (char) (c + 32);
        else
            return c;
    }
}
