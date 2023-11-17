package ChatGPT.BinaryToDecimal.T2;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Loop through the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            // Ensure the input is a valid binary digit (0 or 1)
            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            // Calculate the decimal value using powers of 2
            decimal += digit * Math.pow(2, power);
            power++;
        }

        return decimal;
    }
}
