class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        try:
            decimal = int(binary, 2)
            return decimal
        except ValueError:
            print("Invalid binary input. Please provide a valid binary string.")
            return None
