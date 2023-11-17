from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T5.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.binary_converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test a positive binary number
        binary_string = "1101"
        expected_decimal = 13
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_zero(self):
        # Test conversion of binary zero
        binary_string = "0"
        expected_decimal = 0
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_negative(self):
        # Test a negative binary number (two's complement)
        binary_string = "11111110"
        expected_decimal = -2
        result = self.binary_converter.convert_to_decimal(binary_string)
        self.assertEqual(result, expected_decimal)
