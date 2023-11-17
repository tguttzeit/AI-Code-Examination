# Source: Lambert Kenneth A.: Fundamentals of Python First Programs 2nd Edition, USA, cengage, 2017, S.111


class BinaryToDecimal:

    # CHANGE FOR EXPERIMENT: The original name of this method in the source was "convert_bit_string_to_decimal()"
    def convert_to_decimal(self, bit_string):
        decimal = 0
        exponent = len(bit_string) - 1
        for digit in bit_string:
            decimal = decimal + int(digit) * 2 ** exponent
            exponent = exponent - 1
        return decimal
