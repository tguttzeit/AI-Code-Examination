class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        try:
            decimal = int(binary, 2)  # Convert binary string to decimal integer
            return decimal
        except ValueError:
            raise ValueError("Invalid binary input")
