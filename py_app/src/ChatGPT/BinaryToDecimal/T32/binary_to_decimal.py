class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        # Check if the input is a valid binary string
        if not all(bit in '01' for bit in binary):
            raise ValueError("Invalid binary string")

        # Initialize the decimal value
        decimal = 0
        power = len(binary) - 1  # The highest power of 2

        # Convert binary to decimal using the positional value of each bit
        for bit in binary:
            decimal += int(bit) * (2 ** power)
            power -= 1

        return decimal
