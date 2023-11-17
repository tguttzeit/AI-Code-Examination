class BinaryToDecimal:

    def convert_to_decimal(self, binary):
        if binary == None:
            return 0
        decimal = 0
        power = len(binary) - 1
        for digit in binary:
            decimal += int(digit) * pow(2, power)
            power -= 1
        return decimal
