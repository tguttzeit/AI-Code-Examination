from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T5.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        # Create an instance of BinaryToDecimal for testing
        self.binary_converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test a valid binary input
        binary = "1101"
        decimal = self.binary_converter.convert_to_decimal(binary)
        self.assertEqual(decimal, 13)

    def test_invalid_binary(self):
        # Test an invalid binary input with characters other than 0 and 1
        binary = "1102"
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary)

    def test_empty_binary(self):
        # Test an empty binary input
        binary = ""
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary)

    def test_binary_with_spaces(self):
        # Test a binary input with spaces
        binary = "1 0 1 0"
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary)
