class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        power = 0

        # Loop through the binary string from right to left
        for i in range(len(binary) - 1, -1, -1):
            # If the current character is 1, add 2 to the power of the index to the decimal
            if binary[i] == '1':
                decimal += 2 ** power
            power += 1

        return decimal
