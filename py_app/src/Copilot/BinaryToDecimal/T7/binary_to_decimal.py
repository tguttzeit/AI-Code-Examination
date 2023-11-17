class BinaryToDecimal:
    def __init__(self, binary):
        self.binary = binary

    def convert_to_decimal(self):
        """
        :return: int
        """
        decimal = 0
        for i in range(len(self.binary)):
            decimal += int(self.binary[i]) * 2 ** (len(self.binary) - 1 - i)
        return decimal
