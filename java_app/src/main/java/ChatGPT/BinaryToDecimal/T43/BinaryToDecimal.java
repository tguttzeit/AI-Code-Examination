package ChatGPT.BinaryToDecimal.T43;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            char digitChar = binary.charAt(length - 1 - i);
            int digit = Character.getNumericValue(digitChar);

            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Invalid binary digit: " + digitChar);
            }

            decimal += digit * Math.pow(2, i);
        }

        return decimal;
    }
}
