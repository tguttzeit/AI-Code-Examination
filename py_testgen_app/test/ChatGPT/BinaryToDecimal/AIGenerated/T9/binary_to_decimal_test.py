from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T9.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test with valid binary inputs
        self.assertEqual(self.converter.convert_to_decimal("1010"), 10)
        self.assertEqual(self.converter.convert_to_decimal("1101"), 13)
        self.assertEqual(self.converter.convert_to_decimal("11110000"), 240)

    def test_invalid_binary(self):
        # Test with invalid binary inputs
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("1020")  # Contains a non-binary digit '2'
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("xyz")   # Contains non-numeric characters

    def test_empty_string(self):
        # Test with an empty string input
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("")
