from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T2.binary_to_decimal import BinaryToDecimal

import unittest


class BinaryToDecimalTest(unittest.TestCase):
    # Test1: 0 -> 0
    def test1(self):
        binary = "0"
        decimal = 0
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), decimal)

    # Test2: 1 -> 1
    def test2(self):
        binary = "1"
        decimal = 1
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), decimal)

    # Test3: 10 -> 2
    def test3(self):
        binary = "10"
        decimal = 2
        self.assertEqual(BinaryToDecimal.convert_to_decimal(binary), decimal)
