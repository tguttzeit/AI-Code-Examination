class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        # set decimal to 0
        decimal = 0
        # set power to 0
        power = 0
        # loop through binary in reverse
        for i in range(len(binary) - 1, -1, -1):
            # if binary at i is 1
            if binary[i] == "1":
                # add 2 to the power
                decimal += 2 ** power
            # increment power
            power += 1
        # return decimal
        return decimal
