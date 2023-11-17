class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        try:
            decimal = int(binary, 2)
            return decimal
        except ValueError:
            raise ValueError("Invalid binary input. Please provide a valid binary string.")
