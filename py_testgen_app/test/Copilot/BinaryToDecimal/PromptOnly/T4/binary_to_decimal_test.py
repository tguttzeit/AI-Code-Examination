from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T4.binary_to_decimal import BinaryToDecimal

import unittest


class BinaryToDecimalTest(unittest.TestCase):

    # Create an instance of the class BinaryToDecimal.
    def setUp(self):
        self.binary_to_decimal = BinaryToDecimal()

    # Test that the method convert_to_decimal() returns the correct decimal for the binary 0.
    def test_convert_to_decimal_zero(self):
        self.assertEqual(self.binary_to_decimal.convert_to_decimal('0'), 0)

    # Test that the method convert_to_decimal() returns the correct decimal for the binary 1.
    def test_convert_to_decimal_one(self):
        self.assertEqual(self.binary_to_decimal.convert_to_decimal('1'), 1)

    # Test that the method convert_to_decimal() returns the correct decimal for the binary 101.
    def test_convert_to_decimal_101(self):
        self.assertEqual(self.binary_to_decimal.convert_to_decimal('101'), 5)

    