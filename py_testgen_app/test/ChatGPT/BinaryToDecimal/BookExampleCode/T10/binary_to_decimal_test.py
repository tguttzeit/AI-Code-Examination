from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T10.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test converting a binary number to decimal with a positive value
        result = self.converter.convert_to_decimal("1101")
        self.assertEqual(result, 13)

    def test_binary_to_decimal_zero(self):
        # Test converting a binary number with all zeros to decimal
        result = self.converter.convert_to_decimal("0000")
        self.assertEqual(result, 0)

    def test_binary_to_decimal_negative(self):
        # Test converting a binary number with a negative sign (two's complement)
        result = self.converter.convert_to_decimal("11111100")
        self.assertEqual(result, -4)

    def test_binary_to_decimal_large_number(self):
        # Test converting a large binary number to decimal
        result = self.converter.convert_to_decimal("10101010101010101010")
        self.assertEqual(result, 8730)
