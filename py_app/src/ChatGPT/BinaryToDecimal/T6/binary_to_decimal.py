class BinaryToDecimal:
    def __init__(self, binary):
        self.binary = binary

    def convert_to_decimal(self):
        try:
            decimal = int(self.binary, 2)
            return decimal
        except ValueError:
            raise ValueError("Invalid binary input")
