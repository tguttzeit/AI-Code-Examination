class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        # return int(binary, 2)
        binary_list = [int(i) for i in str(binary)]
        binary_list.reverse()
        decimal = 0
        for i in range(len(binary_list)):
            decimal += binary_list[i] * 2**i
        return decimal
