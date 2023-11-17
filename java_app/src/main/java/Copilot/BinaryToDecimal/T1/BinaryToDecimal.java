package Copilot.BinaryToDecimal.T1;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int result = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }
        return result;
    }
}
