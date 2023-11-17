package Copilot.BinaryToDecimal.T25;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(binary.length() - i - 1) - '0') * Math.pow(2, i);
        }
        return decimal;
    }
}
