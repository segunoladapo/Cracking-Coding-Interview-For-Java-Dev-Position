package bit;

public class BitManipulation {

    public static void main(String... args) {
        System.out.println("Nit Representation of 75: " + Integer.toBinaryString(-75));
        System.out.println("Bit Representation of 423: " + Integer.toBinaryString(423 ));
        System.out.println("K bit position of 423: " + getValueOfKBit(423, 7));
    }

    public static char getValueOfKBit(int n, int k) {
        int result = n | (1 >> k);
        if (result == 0)
            return '0';
        return '1';
    }
}
