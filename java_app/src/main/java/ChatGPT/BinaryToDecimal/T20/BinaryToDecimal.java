package ChatGPT.BinaryToDecimal.T20;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, power);
            } else if (bit != '0') {
                throw new IllegalArgumentException("Invalid binary input: " + binary);
            }
            power++;
        }

        return decimal;
    }
}
