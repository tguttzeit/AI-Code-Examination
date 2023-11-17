package ChatGPT.BinaryToDecimal.T18;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate over the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);

            if (bit == '1') {
                decimal += Math.pow(2, power);
            }

            power++;
        }

        return decimal;
    }
}
