package Copilot.BinaryToDecimal.T45;

public class BinaryToDecimal {
    public int convertToDecimal(String binary){
        int decimal = Integer.parseInt(binary, 2);
        return decimal;
    }
}
