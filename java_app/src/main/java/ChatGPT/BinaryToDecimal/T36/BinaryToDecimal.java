package ChatGPT.BinaryToDecimal.T36;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string is null or empty");
        }

        int decimal = 0;
        int binaryLength = binary.length();

        for (int i = binaryLength - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + c);
            }
            int digit = c - '0'; // Convert char to int (0 or 1)
            decimal += digit * Math.pow(2, binaryLength - 1 - i);
        }

        return decimal;
    }
}
