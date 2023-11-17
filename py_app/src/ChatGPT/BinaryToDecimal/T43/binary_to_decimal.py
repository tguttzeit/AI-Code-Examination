class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        try:
            decimal = int(binary, 2)
            return decimal
        except ValueError:
            raise ValueError("Invalid binary string. It should contain only '0' and '1'.")
