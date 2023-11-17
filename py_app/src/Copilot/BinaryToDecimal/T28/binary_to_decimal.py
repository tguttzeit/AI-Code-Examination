class BinaryToDecimal:
    def __init__(self, binary):
        self.binary = binary

    def convert_to_decimal(self):
        return int(self.binary, 2)
