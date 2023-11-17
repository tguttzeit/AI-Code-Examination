package Copilot.BinaryToDecimal.T27;

public class BinaryToDecimal {

    public int convertToDecimal(String binary) {
        int res = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                res += Math.pow(2, binary.length() - 1 - i);
            }
        }
        return res;
    }
}
