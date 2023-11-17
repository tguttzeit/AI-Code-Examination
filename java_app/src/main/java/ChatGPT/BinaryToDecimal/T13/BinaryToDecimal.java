package ChatGPT.BinaryToDecimal.T13;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Binary string cannot be null or empty");
        }

        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);
            if (digit == '1') {
                decimal += Math.pow(2, power);
            } else if (digit != '0') {
                throw new IllegalArgumentException("Invalid binary digit: " + digit);
            }
            power++;
        }

        return decimal;
    }
}
