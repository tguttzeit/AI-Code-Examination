from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T10.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal1(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("100110"), 38)

    def test_convert_to_decimal2(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("100110011"), 307)

    def test_convert_to_decimal3(self):
        self.assertEqual(BinaryToDecimal().convert_to_decimal("100110011001"), 1233)
