package Copilot.BinaryToDecimal.T14;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int number = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                number += Math.pow(2, power);
            }
            power++;
        }
        return number;
    }
}
