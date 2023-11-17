class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        decimal = 0
        binary = binary[::-1]  # Reverse the binary string to start from the rightmost bit
        for i in range(len(binary)):
            if binary[i] == '1':
                decimal += 2 ** i
        return decimal
