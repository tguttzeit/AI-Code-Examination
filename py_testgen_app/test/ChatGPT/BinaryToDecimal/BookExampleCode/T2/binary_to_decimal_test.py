from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T2.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        # Create an instance of the BinaryToDecimal class for testing
        self.converter = BinaryToDecimal()

    def test_convert_to_decimal_positive(self):
        # Test converting a positive binary number to decimal
        bit_string = "1101"
        expected_decimal = 13
        result = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(result, expected_decimal)

    def test_convert_to_decimal_zero(self):
        # Test converting binary zero to decimal
        bit_string = "0"
        expected_decimal = 0
        result = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(result, expected_decimal)

    def test_convert_to_decimal_negative(self):
        # Test converting a negative binary number to decimal
        bit_string = "-1101"  # Assuming you want to handle negative numbers
        expected_decimal = -13
        result = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(result, expected_decimal)
