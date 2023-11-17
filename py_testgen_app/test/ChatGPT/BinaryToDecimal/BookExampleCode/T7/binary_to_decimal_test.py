from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T7.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        # Initialize the BinaryToDecimal instance
        self.binary_converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test a positive binary number
        binary_string = "1101"
        expected_decimal = 13
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_zero(self):
        # Test the binary number '0'
        binary_string = "0"
        expected_decimal = 0
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_negative(self):
        # Test a large binary number (negative)
        binary_string = "11111111111111111111111111111111"
        expected_decimal = 2**32 - 1  # Maximum 32-bit signed integer value
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)

