package Copilot.BinaryToDecimal.T10;

public class BinaryToDecimal {

    // Your code here
    public int convertToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, binary.length() - i - 1);
            }
        }
        return decimal;
    }

}
