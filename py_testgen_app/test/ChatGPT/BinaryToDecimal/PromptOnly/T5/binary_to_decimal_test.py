from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T5.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal_positive(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("1101"), 13)
        self.assertEqual(BinaryToDecimal().convert_to_decimal("101010"), 42)
        self.assertEqual(BinaryToDecimal().convert_to_decimal("11111111"), 255)

    def test_binary_to_decimal_zero(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("0"), 0)
        self.assertEqual(BinaryToDecimal().convert_to_decimal("0000"), 0)

    def test_binary_to_decimal_negative(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("1110"), 14)
        self.assertEqual(BinaryToDecimal().convert_to_decimal("1001101"), 77)
        self.assertEqual(BinaryToDecimal().convert_to_decimal("1101101"), 109)

