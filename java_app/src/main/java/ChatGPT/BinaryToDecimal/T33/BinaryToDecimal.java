package ChatGPT.BinaryToDecimal.T33;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);

            // Ensure the character is '0' or '1'
            if (digitChar != '0' && digitChar != '1') {
                throw new IllegalArgumentException("Invalid binary string");
            }

            int digitValue = Character.getNumericValue(digitChar);

            // Calculate the decimal value using powers of 2
            decimal += digitValue * Math.pow(2, power);
            power++;
        }

        return decimal;
    }
}
