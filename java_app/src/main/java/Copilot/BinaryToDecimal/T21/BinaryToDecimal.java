package Copilot.BinaryToDecimal.T21;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        int start = binary.length() - 1;
        for (int i = start; i >= 0; i--) {
            decimal += Integer.parseInt(binary.charAt(i) + "") * Math.pow(2, power);
            power++;
        }
        return decimal;
    }

}
