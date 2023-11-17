class BinaryToDecimal:
    def __init__(self, binary):
        self.binary = binary

    def convert_to_decimal(self):
        try:
            decimal = int(self.binary, 2)
            return decimal
        except ValueError:
            print("Invalid binary input. Please provide a valid binary string.")
            return None
