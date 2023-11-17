class BinaryToDecimal:

    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        return int(binary, 2)

    # def convert_to_decimal(self, binary):
    #     decimal = 0
    #     for digit in binary:
    #         decimal = decimal * 2 + int(digit)
    #     return decimal
