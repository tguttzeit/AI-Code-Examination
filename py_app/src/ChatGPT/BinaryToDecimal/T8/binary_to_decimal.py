class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        try:
            decimal = int(binary, 2)
            return decimal
        except ValueError:
            raise ValueError("Input is not a valid binary string")
