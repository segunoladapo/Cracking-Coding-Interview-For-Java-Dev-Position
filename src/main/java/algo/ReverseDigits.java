package algo;

public class ReverseDigits {

    public static int reverse(int digits) {
        int reverserNum = 0;
        while (digits > 0) {
            reverserNum = (reverserNum * 10) + (digits % 10);
            digits = digits / 10;
        }
        return reverserNum;
    }

    public static void main(String... args) {
        int reverserNum = reverse(231);
        System.out.println(reverserNum);
    }
}
