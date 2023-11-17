class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0

        # Iterate through the binary string in reverse order
        for bit in reversed(binary):
            if bit == '1':
                decimal += 2 ** power
            elif bit != '0':
                raise ValueError("Invalid binary input: " + binary)
            power += 1

        return decimal
