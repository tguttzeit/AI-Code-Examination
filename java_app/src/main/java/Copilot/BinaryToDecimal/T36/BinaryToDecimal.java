package Copilot.BinaryToDecimal.T36;

public class BinaryToDecimal {
    public int convertToDecimal(String binary) {
        int length = binary.length();
        int dec = 0;
        for (int i = 0; i < length; i++) {
            int digit = Integer.parseInt(binary.substring(i, i+1));
            dec += digit * Math.pow(2, length - 1 - i);
        }
        return dec;
    }
}
