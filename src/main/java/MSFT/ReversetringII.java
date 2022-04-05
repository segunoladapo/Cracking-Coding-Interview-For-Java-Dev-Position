package MSFT;

public class ReversetringII {

    public static char[] reverseWord(char[] input) {
        reverse(input, 0, input.length - 1);
        return input;
    }

    public static void reverse(char[] input, int start, int end) {
        while (start < end) {
            char temp = input[start];
            input[end] = input[end];
            input[start] = temp;
        }
    }

    public static void reverseWords(char[] input) {
        for(int i = 0, j = 0;i <= input.length;i++){
            if(i==input.length || input[i] == ' '){
                reverse(input,j,i-1);
                j = i+1;
            }
        }
    }
}
