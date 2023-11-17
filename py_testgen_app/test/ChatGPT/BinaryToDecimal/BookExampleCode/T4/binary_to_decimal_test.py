from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T4.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test converting a binary number to decimal (positive case)
        binary_str = "1010"
        expected_decimal = 10
        result = self.converter.convert_to_decimal(binary_str)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_zero(self):
        # Test converting the binary number "0" to decimal
        binary_str = "0"
        expected_decimal = 0
        result = self.converter.convert_to_decimal(binary_str)
        self.assertEqual(result, expected_decimal)

    def test_binary_to_decimal_negative(self):
        # Test converting a larger binary number to decimal (negative case)
        binary_str = "110111"
        expected_decimal = 55  # Incorrect value to test failure
        result = self.converter.convert_to_decimal(binary_str)
        self.assertNotEqual(result, expected_decimal)
