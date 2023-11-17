package ChatGPT.BinaryToDecimal.T19;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);

            // Check if the character is '1'
            if (c == '1') {
                // Add the corresponding power of 2 to the decimal value
                decimal += Math.pow(2, power);
            }

            power++; // Increment the power for the next position
        }

        return decimal;
    }
}
