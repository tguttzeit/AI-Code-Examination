package Copilot.BinaryToDecimal.T32;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int sum = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                sum += Math.pow(2, power);
            }
            power++;
        }
        return sum;
    }
}
