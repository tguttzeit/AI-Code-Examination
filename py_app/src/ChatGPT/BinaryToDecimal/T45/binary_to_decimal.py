class BinaryToDecimal:
    def __init__(self, binary):
        self.binary = binary

    def convert_to_decimal(self):
        decimal = 0
        binary_str = str(self.binary)
        length = len(binary_str)

        for i in range(length):
            if binary_str[i] == '1':
                decimal += 2 ** (length - 1 - i)

        return decimal
