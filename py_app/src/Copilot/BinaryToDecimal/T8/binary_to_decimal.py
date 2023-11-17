class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0
        for i in range(len(binary) - 1, -1, -1):
            if binary[i] == '1':
                decimal += 2 ** power
            power += 1
        return decimal
