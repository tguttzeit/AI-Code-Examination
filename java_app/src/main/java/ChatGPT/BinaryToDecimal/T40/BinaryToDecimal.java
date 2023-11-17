package ChatGPT.BinaryToDecimal.T40;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int base = 1; // The base for the leftmost digit (2^0)

        // Iterate through the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);

            if (digitChar == '1') {
                decimal += base;
            } else if (digitChar != '0') {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            // Update the base for the next digit (2^1, 2^2, ...)
            base *= 2;
        }

        return decimal;
    }
}
