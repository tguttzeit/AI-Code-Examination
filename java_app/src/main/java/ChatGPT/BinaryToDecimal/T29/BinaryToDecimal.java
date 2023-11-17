package ChatGPT.BinaryToDecimal.T29;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string cannot be null or empty.");
        }

        int decimal = 0;
        int binaryLength = binary.length();

        for (int i = 0; i < binaryLength; i++) {
            char digit = binary.charAt(binaryLength - 1 - i);

            if (digit != '0' && digit != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + digit);
            }

            int powerOfTwo = (int) Math.pow(2, i);
            int digitValue = digit == '1' ? 1 : 0;
            decimal += digitValue * powerOfTwo;
        }

        return decimal;
    }
}
