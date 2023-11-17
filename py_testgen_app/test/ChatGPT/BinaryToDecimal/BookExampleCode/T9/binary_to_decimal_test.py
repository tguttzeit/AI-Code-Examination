from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T9.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal_positive(self):
        # Test a positive binary number
        bit_string = "1101"
        decimal = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(decimal, 13)

    def test_binary_to_decimal_negative(self):
        # Test a negative binary number (with a negative sign)
        bit_string = "-1010"
        decimal = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(decimal, -10)

    def test_binary_to_decimal_zero(self):
        # Test conversion of binary "0" to decimal
        bit_string = "0"
        decimal = self.converter.convert_to_decimal(bit_string)
        self.assertEqual(decimal, 0)

    def test_binary_to_decimal_empty(self):
        # Test conversion of an empty binary string
        bit_string = ""
        # You can use assertRaises to check if an exception is raised for invalid input
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(bit_string)
