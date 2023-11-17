package Copilot.BinaryToDecimal.T8;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += power;
            }
            power *= 2;
        }
        return decimal;
    }
}
