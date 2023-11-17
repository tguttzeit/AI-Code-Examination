from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T8.binary_to_decimal import BinaryToDecimal

import unittest


def test_binary_to_decimal(self):
    binary_to_decimal = BinaryToDecimal()
    self.assertEqual(0, binary_to_decimal.convert_to_decimal("0"))
    self.assertEqual(1, binary_to_decimal.convert_to_decimal("1"))
    self.assertEqual(2, binary_to_decimal.convert_to_decimal("10"))
    self.assertEqual(3, binary_to_decimal.convert_to_decimal("11"))
    self.assertEqual(4, binary_to_decimal.convert_to_decimal("100"))
    self.assertEqual(5, binary_to_decimal.convert_to_decimal("101"))
    self.assertEqual(6, binary_to_decimal.convert_to_decimal("110"))
    self.assertEqual(7, binary_to_decimal.convert_to_decimal("111"))
    self.assertEqual(8, binary_to_decimal.convert_to_decimal("1000"))
    self.assertEqual(9, binary_to_decimal.convert_to_decimal("1001"))
    self.assertEqual(10, binary_to_decimal.convert_to_decimal("1010"))
    self.assertEqual(11, binary_to_decimal.convert_to_decimal("1011"))
    self.assertEqual(12, binary_to_decimal.convert_to_decimal("1100"))
    self.assertEqual(13, binary_to_decimal.convert_to_decimal("1101"))
    self.assertEqual(14, binary_to_decimal.convert_to_decimal("1110"))
    self.assertEqual(15, binary_to_decimal.convert_to_decimal("1111"))
    self.assertEqual(16, binary_to_decimal.convert_to_decimal("10000"))
    self.assertEqual(17, binary_to_decimal.convert_to_decimal("10001"))
    self.assertEqual(18, binary_to_decimal.convert_to_decimal("10010"))
    self.assertEqual(19, binary_to_decimal.convert_to_decimal("10011"))
    self.assertEqual(20, binary_to_decimal.convert_to_decimal("10100"))
    self.assertEqual(21, binary_to_decimal.convert_to_decimal("10101"))
    self.assertEqual(22, binary_to_decimal.convert_to_decimal("10110"))
    self.assertEqual(23, binary_to_decimal.convert_to_decimal("10111"))
    self.assertEqual(24, binary_to_decimal.convert_to_decimal("11000"))
    self.assertEqual(25, binary_to_decimal.convert_to_decimal("11001"))
    self.assertEqual(26, binary_to_decimal.convert_to_decimal("11010"))
    self.assertEqual(27, binary_to_decimal.convert_to_decimal("11011"))
    self.assertEqual(28, binary_to_decimal.convert_to_decimal("11100"))
    self.assertEqual(29, binary_to_decimal.convert_to_decimal("11101"))
    self.assertEqual(30, binary_to_decimal.convert
