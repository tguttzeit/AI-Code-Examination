class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        # Check if the input is a valid binary string
        if not self.is_valid_binary(binary):
            raise ValueError("Invalid binary input")

        decimal = 0
        binary_length = len(binary)

        # Convert the binary string to decimal
        for i in range(binary_length):
            if binary[i] == '1':
                decimal += 2 ** (binary_length - 1 - i)

        return decimal

    def is_valid_binary(self, binary):
        # Check if the input string consists of only 0s and 1s
        return all(bit in '01' for bit in binary)
