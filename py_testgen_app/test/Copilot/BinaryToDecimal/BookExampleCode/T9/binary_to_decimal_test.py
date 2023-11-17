from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T9.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal(self):
        binary_to_decimal = BinaryToDecimal()
        self.assertEqual(binary_to_decimal.convert_to_decimal('1001'), 9)
        self.assertEqual(binary_to_decimal.convert_to_decimal('1111'), 15)
        self.assertEqual(binary_to_decimal.convert_to_decimal('111'), 7)
        self.assertEqual(binary_to_decimal.convert_to_decimal('1010'), 10)