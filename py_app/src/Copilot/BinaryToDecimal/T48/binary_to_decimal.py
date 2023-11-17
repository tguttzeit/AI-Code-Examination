class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        if binary == None:
            return None
        else:
            decimal = 0
            power = 0
            for i in range(len(binary)-1, -1, -1):
                decimal += int(binary[i]) * (2 ** power)
                power += 1
            return decimal
