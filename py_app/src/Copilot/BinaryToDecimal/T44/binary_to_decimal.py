class BinaryToDecimal:

    def convert_to_decimal(self, binary):
        # Your code goes here
        decimal = 0
        for digit in binary:
            decimal = decimal * 2 + int(digit)
        return decimal
