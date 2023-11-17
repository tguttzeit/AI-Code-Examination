class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        for i in range(len(binary)):
            if binary[i] == '1':
                decimal += 2**(len(binary)-i-1)
        return decimal
