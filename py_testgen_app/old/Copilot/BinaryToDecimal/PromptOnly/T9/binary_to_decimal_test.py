from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T9.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):

    # Test case 1: binary = "101"
    def test_convert_to_decimal1(self):
        binary = "101"
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), 5)

    # Test case 2: binary = "110"
    def test_convert_to_decimal2(self):
        binary = "110"
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), 6)

    # Test case 3: binary = "111"
    def test_convert_to_decimal3(self):
        binary = "111"
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), 7)
