class BinaryToDecimal:
    def convert_to_decimal(self, binary):
        if not binary:
            raise ValueError("Input binary string is empty")

        decimal = 0
        base = 2
        binary = binary[::-1]  # Reverse the binary string to start from the rightmost digit

        for i, digit in enumerate(binary):
            if digit not in ('0', '1'):
                raise ValueError(f"Invalid binary digit at position {i}: {digit}")

            # Convert the binary digit to an integer and add it to the decimal value
            decimal += int(digit) * (base ** i)

        return decimal
