package ChatGPT.BinaryToDecimal.T50;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string is null or empty");
        }

        int decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            char digitChar = binary.charAt(length - 1 - i);
            if (digitChar != '0' && digitChar != '1') {
                throw new IllegalArgumentException("Input binary string contains non-binary characters");
            }

            int digitValue = Character.getNumericValue(digitChar);
            decimal += digitValue * Math.pow(2, i);
        }

        return decimal;
    }
}
