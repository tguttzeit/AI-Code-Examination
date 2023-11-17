from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T7.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.binary_converter = BinaryToDecimal()

    def test_valid_binary_conversion(self):
        # Test converting a valid binary number to decimal
        binary_input = "1101"
        expected_decimal = 13
        result = self.binary_converter.convert_to_decimal(binary_input)
        self.assertEqual(result, expected_decimal)

    def test_invalid_binary_input(self):
        # Test converting an invalid binary input (contains a non-binary character)
        binary_input = "1102"  # Contains '2,' which is not a valid binary digit
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary_input)

    def test_empty_binary_input(self):
        # Test converting an empty binary input
        binary_input = ""
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal(binary_input)
