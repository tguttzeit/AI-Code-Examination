package Copilot.BinaryToDecimal.T22;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result += (binary.charAt(i) - '0') * Math.pow(2, binary.length() - i - 1);
        }
        return result;
    }
}
