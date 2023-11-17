class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        if binary == None:
            return 0
        decimal = 0
        power = 0
        index = len(binary) - 1
        while index >= 0:
            decimal += int(binary[index]) * pow(2, power)
            power += 1
            index -= 1
        return decimal
