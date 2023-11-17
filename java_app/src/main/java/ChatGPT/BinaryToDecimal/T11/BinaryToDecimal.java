package ChatGPT.BinaryToDecimal.T11;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c == '1') {
                // Add the appropriate power of 2 to the decimal value
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }
}
