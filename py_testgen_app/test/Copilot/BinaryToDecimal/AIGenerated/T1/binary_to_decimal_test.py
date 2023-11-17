from py_testgen_app.src.Copilot.BinaryToDecimal.AIGenerated.T1.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1001'), 9)
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1010'), 10)
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1011'), 11)