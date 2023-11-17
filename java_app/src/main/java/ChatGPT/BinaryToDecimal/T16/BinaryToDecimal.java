package ChatGPT.BinaryToDecimal.T16;

public class BinaryToDecimal {

    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input binary string is invalid");
        }

        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + c);
            }
            int bitValue = c == '1' ? 1 : 0;
            decimal += bitValue * Math.pow(2, power);
            power++;
        }

        return decimal;
    }
}
