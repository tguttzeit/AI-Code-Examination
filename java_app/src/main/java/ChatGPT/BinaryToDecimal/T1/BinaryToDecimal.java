package ChatGPT.BinaryToDecimal.T1;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate over the binary string in reverse order
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);

            if (digitChar == '1') {
                decimal += Math.pow(2, power);
            } else if (digitChar != '0') {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            power++;
        }

        return decimal;
    }
}
