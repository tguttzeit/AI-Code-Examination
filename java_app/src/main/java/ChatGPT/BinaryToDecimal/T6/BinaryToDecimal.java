package ChatGPT.BinaryToDecimal.T6;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();

        for (int i = length - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0';

            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Input string is not a binary number.");
            }

            decimal += digit * Math.pow(2, length - 1 - i);
        }

        return decimal;
    }
}
