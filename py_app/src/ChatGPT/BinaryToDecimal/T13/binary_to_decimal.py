class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0

        # Iterate through the binary string in reverse order
        for digit in reversed(binary):
            if digit == '1':
                decimal += 2 ** power
            elif digit != '0':
                raise ValueError("Invalid binary input: should contain only '0' and '1'")
            power += 1

        return decimal
