package MSFT;

public class MyAtoiApp {

    public static void main(String args) {
        System.out.println(myAtoi("4500"));
    }

    public static int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        int i = 0;
        if ('-' == str.charAt(0)) {
            sign = -1;
            i++;
        }
        for (; i < str.length(); ++i) {
            res = res * 10 + str.charAt(i) - '0'; //get numerical value
        }
        return sign * res;
    }
}
