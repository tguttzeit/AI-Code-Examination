from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T9.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):

    def test_valid_binary(self):
        # Test with valid binary input
        binary = "1010"
        decimal = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(decimal, 10)

    def test_binary_with_zero(self):
        # Test binary input with leading zeros
        binary = "00110011"
        decimal = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(decimal, 51)

    def test_invalid_binary(self):
        # Test with invalid binary input
        binary = "12345"  # Not a valid binary string
        with self.assertRaises(ValueError):
            BinaryToDecimal.convert_to_decimal(binary)

