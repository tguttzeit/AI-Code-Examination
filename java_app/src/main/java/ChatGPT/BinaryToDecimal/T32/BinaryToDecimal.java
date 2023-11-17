package ChatGPT.BinaryToDecimal.T32;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        // Check if the input is null or empty
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string is null or empty");
        }

        int decimal = 0;
        int power = 0;

        // Iterate through the binary string in reverse
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            // Validate that the character is a valid binary digit (0 or 1)
            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            // Convert binary to decimal using the formula: decimal += digit * 2^power
            decimal += digit * Math.pow(2, power);
            power++;
        }

        return decimal;
    }
}
