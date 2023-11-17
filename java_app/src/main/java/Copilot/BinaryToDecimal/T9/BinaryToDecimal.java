package Copilot.BinaryToDecimal.T9;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int num = Character.getNumericValue(binary.charAt(i));
            decimal += num * Math.pow(2, power);
            power++;
        }
        return decimal;
    }
}
