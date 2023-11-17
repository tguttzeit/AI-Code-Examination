from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T4.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test with valid binary input
        binary = "1010"
        decimal = self.converter.convert_to_decimal(binary)
        self.assertEqual(decimal, 10)

    def test_invalid_binary(self):
        # Test with invalid binary input (contains a non-binary character)
        binary = "1021"
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)

    def test_empty_binary(self):
        # Test with empty binary input
        binary = ""
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)

    def test_binary_with_spaces(self):
        # Test with binary input containing spaces (should be treated as valid)
        binary = "1 0011"
        decimal = self.converter.convert_to_decimal(binary)
        self.assertEqual(decimal, 19)
