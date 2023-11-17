package Copilot.BinaryToDecimal.T15;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, (length - 1 - i));
            }
        }
        return decimal;
    }
}
