package Copilot.BinaryToDecimal.T29;

public class BinaryToDecimal {

    public static int convertToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal * 2 + Character.getNumericValue(binary.charAt(i));
        }
        return decimal;
    }
}
