from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T7.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal_101(self):
        binary_to_decimal = BinaryToDecimal()
        self.assertEqual(binary_to_decimal.convert_to_decimal("101"), 5)

    def test_convert_to_decimal_111(self):
        binary_to_decimal = BinaryToDecimal()
        self.assertEqual(binary_to_decimal.convert_to_decimal("111"), 7)

    def test_convert_to_decimal_1001(self):
        binary_to_decimal = BinaryToDecimal()
        self.assertEqual(binary_to_decimal.convert_to_decimal("1001"), 9)