class BinaryToDecimal:
    def __init__(self):
        pass

    @staticmethod
    def convert_to_decimal(binary):
        try:
            decimal = int(binary, 2)
            return decimal
        except ValueError:
            raise ValueError("Invalid binary input. Please provide a valid binary string.")
