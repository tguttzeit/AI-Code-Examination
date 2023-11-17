from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T6.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test converting a positive binary number to decimal
        self.assertEqual(self.converter.convert_to_decimal("1101"), 13)

    def test_binary_to_decimal_zero(self):
        # Test converting zero in binary to decimal
        self.assertEqual(self.converter.convert_to_decimal("0"), 0)

    def test_binary_to_decimal_negative(self):
        # Test converting a binary number with a negative sign to decimal
        # In this case, the function should handle it as a regular binary number.
        self.assertEqual(self.converter.convert_to_decimal("-1101"), -13)
