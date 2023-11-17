class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        # Check if the input is a valid binary string
        if not all(bit in '01' for bit in binary):
            raise ValueError("Input is not a valid binary string")

        decimal = 0
        binary = binary[::-1]  # Reverse the binary string

        # Convert binary to decimal
        for i, bit in enumerate(binary):
            if bit == '1':
                decimal += 2 ** i

        return decimal
