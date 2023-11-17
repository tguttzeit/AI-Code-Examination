class BinaryToDecimal:
    def __init__(self):
        self.binary = ""

    def convert_to_decimal(self, binary):
        # write your code here
        self.binary = binary
        return int(self.binary, 2)
