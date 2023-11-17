from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T2.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_positive(self):
        # Test conversion of a positive binary number to decimal
        binary = "101010"
        decimal = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(decimal, 42)

    def test_binary_to_decimal_negative(self):
        # Test conversion of a negative binary number to decimal
        binary = "-1101"
        decimal = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(decimal, -13)

    def test_binary_to_decimal_zero(self):
        # Test conversion of zero binary to decimal
        binary = "0"
        decimal = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(decimal, 0)

    def test_binary_to_decimal_invalid_input(self):
        # Test conversion with invalid binary input
        binary = "12345"  # Invalid binary string
        with self.assertRaises(ValueError):
            BinaryToDecimal.convert_to_decimal(binary)
