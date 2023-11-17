from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T2.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.binary_converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test for a valid binary input
        self.assertEqual(self.binary_converter.convert_to_decimal("1101"), 13)

    def test_invalid_binary(self):
        # Test for an invalid binary input with characters other than 0 and 1
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal("1234")

    def test_empty_input(self):
        # Test for an empty binary input
        with self.assertRaises(ValueError):
            self.binary_converter.convert_to_decimal("")
