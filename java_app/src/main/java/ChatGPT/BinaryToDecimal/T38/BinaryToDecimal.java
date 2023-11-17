package ChatGPT.BinaryToDecimal.T38;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string is null or empty.");
        }

        int decimal = 0;
        int binaryLength = binary.length();

        for (int i = 0; i < binaryLength; i++) {
            char digit = binary.charAt(binaryLength - i - 1);
            if (digit != '0' && digit != '1') {
                throw new IllegalArgumentException("Input binary string contains non-binary characters.");
            }
            int power = (digit == '1') ? 1 : 0;
            decimal += power * Math.pow(2, i);
        }

        return decimal;
    }
}
