class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        binary = int(binary)
        decimal = 0
        i = 0
        while binary != 0:
            remainder = binary % 10
            decimal = decimal + remainder * pow(2, i)
            binary = binary // 10
            i = i + 1
        return decimal
