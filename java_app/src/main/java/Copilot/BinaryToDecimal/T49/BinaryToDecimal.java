package Copilot.BinaryToDecimal.T49;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int digit = Character.getNumericValue(binary.charAt(i));
            int power = binary.length() - 1 - i;
            decimal += digit * Math.pow(2, power);
        }
        return decimal;
    }
}
