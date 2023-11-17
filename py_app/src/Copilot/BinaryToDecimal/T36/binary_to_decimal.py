class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        for i in range(len(binary)):
            decimal += int(binary[i]) * pow(2, len(binary) - 1 - i)
        return decimal