class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0

        # Reverse the binary string and iterate through its characters
        for bit in reversed(binary):
            if bit == '1':
                decimal += 2 ** power
            elif bit != '0':
                raise ValueError("Invalid binary string")

            power += 1

        return decimal
