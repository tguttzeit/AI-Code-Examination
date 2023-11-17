package ChatGPT.BinaryToDecimal.T24;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Binary string cannot be null or empty");
        }

        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char digitChar = binary.charAt(i);
            if (digitChar != '0' && digitChar != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            int digit = digitChar - '0'; // Convert char to int
            decimal += digit * Math.pow(2, power);
            power++;
        }

        return decimal;
    }
}
