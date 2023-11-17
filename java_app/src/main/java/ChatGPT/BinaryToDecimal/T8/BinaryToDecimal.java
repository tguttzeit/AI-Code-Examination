package ChatGPT.BinaryToDecimal.T8;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            if (digit == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }
}
