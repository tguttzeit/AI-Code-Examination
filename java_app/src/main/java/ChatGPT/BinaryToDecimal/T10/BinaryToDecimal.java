package ChatGPT.BinaryToDecimal.T10;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Loop through the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            // Convert the character to an integer
            int digit = binary.charAt(i) - '0';

            // Update the decimal value by adding the current binary digit times 2 raised to
            // the power
            decimal += digit * Math.pow(2, power);

            // Increment the power for the next digit
            power++;
        }

        return decimal;
    }
}
