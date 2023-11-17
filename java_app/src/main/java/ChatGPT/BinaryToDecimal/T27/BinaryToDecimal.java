package ChatGPT.BinaryToDecimal.T27;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            // Convert the character at position i to an integer
            int bit = binary.charAt(i) - '0';

            // Add the decimal value of the bit to the result
            decimal += bit * Math.pow(2, power);

            // Increment the power for the next bit
            power++;
        }

        return decimal;
    }
}
