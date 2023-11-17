from py_testgen_app.src.Copilot.BinaryToDecimal.AIGenerated.T7.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('11101101'), 237)
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1000001'), 65)
        self.assertEqual(BinaryToDecimal.convert_to_decimal('11111111'), 255)