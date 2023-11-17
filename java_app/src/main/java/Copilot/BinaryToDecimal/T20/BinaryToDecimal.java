package Copilot.BinaryToDecimal.T20;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for(int i = binary.length() - 1; i >= 0; i--) {
            decimal += Math.pow(2, power) * Character.getNumericValue(binary.charAt(i));
            power++;
        }
        return decimal;
    }

}
