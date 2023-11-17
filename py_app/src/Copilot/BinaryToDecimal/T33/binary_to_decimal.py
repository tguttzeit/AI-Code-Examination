class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        if binary == None:
            raise TypeError('binary cannot be None')
        if binary == '':
            raise ValueError('binary cannot be empty')
        decimal = 0
        position = len(binary) - 1
        for binary_digit in binary:
            if binary_digit != '0' and binary_digit != '1':
                raise ValueError('binary can only contain 0s and 1s')
            decimal += int(binary_digit) * (2 ** position)
            position -= 1
        return decimal
