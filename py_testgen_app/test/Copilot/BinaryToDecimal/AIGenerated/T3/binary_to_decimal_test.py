from py_testgen_app.src.Copilot.BinaryToDecimal.AIGenerated.T3.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal("0"), 0)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("1"), 1)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("10"), 2)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("11"), 3)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("101"), 5)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("111"), 7)
        self.assertEqual(BinaryToDecimal.convert_to_decimal("1000"), 8)