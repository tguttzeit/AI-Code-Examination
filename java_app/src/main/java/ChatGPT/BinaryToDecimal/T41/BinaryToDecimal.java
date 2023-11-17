package ChatGPT.BinaryToDecimal.T41;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(binary.charAt(length - 1 - i));
            decimal += digit * Math.pow(2, i);
        }

        return decimal;
    }
}
