from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T10.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_valid_binary(self):
        binary = "1010"
        expected_decimal = 10
        decimal = self.converter.convert_to_decimal(binary)
        self.assertEqual(decimal, expected_decimal)

    def test_invalid_binary(self):
        binary = "1021"  # Invalid binary with '2'
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)

    def test_empty_binary(self):
        binary = ""  # Empty binary string
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)
