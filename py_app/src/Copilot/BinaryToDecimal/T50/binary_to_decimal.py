class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        # write your code here
        decimal = 0
        for i in range(len(binary)):
            decimal += int(binary[i]) * 2 ** (len(binary) - i - 1)
        return decimal
