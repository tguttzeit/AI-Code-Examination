package Copilot.BinaryToDecimal.T11;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int len = binary.length();
        for (int i = 0; i < len; i++) {
            if (binary.charAt(len - i - 1) == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }
}
