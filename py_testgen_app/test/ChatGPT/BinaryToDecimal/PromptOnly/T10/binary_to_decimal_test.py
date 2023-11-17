from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T10.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_valid(self):
        # Test a valid binary string
        binary = "1101"
        decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(decimal, 13)

    def test_binary_to_decimal_zero(self):
        # Test with binary string representing zero
        binary = "0"
        decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(decimal, 0)

    def test_binary_to_decimal_large_number(self):
        # Test with a large binary string
        binary = "10101010101010101010101010101010101010101010101010"
        decimal = BinaryToDecimal().convert_to_decimal(binary)
        self.assertEqual(decimal, 292734846921)

    def test_binary_to_decimal_invalid(self):
        # Test with an invalid binary string
        binary = "1234"
        with self.assertRaises(ValueError):
            BinaryToDecimal().convert_to_decimal(binary)

