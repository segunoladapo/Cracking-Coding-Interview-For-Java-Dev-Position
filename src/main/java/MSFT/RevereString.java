package MSFT;

public class RevereString {

    public static void main(String args) {

    }

    public static char[] reverse(char[] input) {
        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            char element = input[start];
            char temp = element;
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return input;
    }
}
