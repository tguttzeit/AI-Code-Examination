class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        dec = 0
        for i in range(len(binary)):
            dec += int(binary[i]) * (2 ** (len(binary) - i - 1))
        return dec
