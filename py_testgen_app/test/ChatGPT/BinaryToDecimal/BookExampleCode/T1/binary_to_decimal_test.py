from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T1.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.binary_converter = BinaryToDecimal()

    def test_binary_to_decimal(self):
        # Test case 1: Binary "101" should convert to decimal 5
        result = self.binary_converter.convert_to_decimal("101")
        self.assertEqual(result, 5)

    def test_binary_to_decimal_with_zero(self):
        # Test case 2: Binary "1100" should convert to decimal 12
        result = self.binary_converter.convert_to_decimal("1100")
        self.assertEqual(result, 12)

    def test_binary_to_decimal_with_large_number(self):
        # Test case 3: Binary "1111111111" (10 ones) should convert to decimal 1023
        result = self.binary_converter.convert_to_decimal("1111111111")
        self.assertEqual(result, 1023)

