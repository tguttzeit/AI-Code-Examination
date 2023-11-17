package ChatGPT.BinaryToDecimal.T39;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();

        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binary.charAt(i));
            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Input is not a binary number.");
            }
            int positionValue = (int) Math.pow(2, length - 1 - i);
            decimal += digit * positionValue;
        }

        return decimal;
    }
}
