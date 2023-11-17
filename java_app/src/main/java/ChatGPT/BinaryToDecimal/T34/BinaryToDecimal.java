package ChatGPT.BinaryToDecimal.T34;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int base = 1; // Represents the current power of 2

        // Iterate through the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);
            if (digitChar == '1') {
                decimal += base; // Add the appropriate power of 2 to the decimal value
            }
            base *= 2; // Move to the next power of 2
        }

        return decimal;
    }
}
