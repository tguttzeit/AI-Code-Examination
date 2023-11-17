from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T3.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        # Create an instance of BinaryToDecimal for testing
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal(self):
        # Test case 1: Binary number 1101 should be converted to decimal 13
        self.assertEqual(self.converter.convert_to_decimal("1101"), 13)

    def test_binary_to_decimal_with_zeros(self):
        # Test case 2: Binary number 1000001 should be converted to decimal 65
        self.assertEqual(self.converter.convert_to_decimal("1000001"), 65)

    def test_binary_to_decimal_with_ones(self):
        # Test case 3: Binary number 11111 should be converted to decimal 31
        self.assertEqual(self.converter.convert_to_decimal("11111"), 31)
