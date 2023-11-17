from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T1.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.binary_converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test a valid binary input
        binary = "101010"
        expected_decimal = 42
        result = self.binary_converter.convert_to_decimal(binary)
        self.assertEqual(result, expected_decimal)

    def test_invalid_binary(self):
        # Test an invalid binary input with characters other than 0 and 1
        binary = "101A01"
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary)

    def test_empty_binary(self):
        # Test an empty binary input
        binary = ""
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary)

    def test_binary_with_spaces(self):
        # Test a binary input with leading and trailing spaces
        binary = "  1101  "
        expected_decimal = 13
        result = self.binary_converter.convert_to_decimal(binary)
        self.assertEqual(result, expected_decimal)
