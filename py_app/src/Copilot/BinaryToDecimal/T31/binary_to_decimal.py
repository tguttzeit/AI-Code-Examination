class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0
        for digit in binary[::-1]:
            decimal += int(digit) * (2 ** power)
            power += 1
        return decimal
