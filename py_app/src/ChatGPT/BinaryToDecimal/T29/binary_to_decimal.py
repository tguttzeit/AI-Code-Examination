class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        # Check if the input is a valid binary string
        if not all(bit in '01' for bit in binary):
            raise ValueError("Input is not a valid binary string")

        # Use int() with base 2 to convert the binary string to decimal
        decimal = int(binary, 2)
        return decimal
