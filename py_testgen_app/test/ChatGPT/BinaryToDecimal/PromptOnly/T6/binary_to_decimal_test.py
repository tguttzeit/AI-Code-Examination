from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T6.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):

    def test_convert_to_decimal_positive(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal("1101")
        self.assertEqual(result, 13)

    def test_convert_to_decimal_negative(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal("10101")
        self.assertEqual(result, 21)

    def test_convert_to_decimal_zero(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal("0")
        self.assertEqual(result, 0)

