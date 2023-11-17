from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T3.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_valid_binary(self):
        # Test converting valid binary numbers to decimal
        self.assertEqual(self.converter.convert_to_decimal("1101"), 13)
        self.assertEqual(self.converter.convert_to_decimal("10101"), 21)
        self.assertEqual(self.converter.convert_to_decimal("11111111"), 255)

    def test_invalid_binary(self):
        # Test raising an exception for invalid binary input
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("1234")

        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("10102")

        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("1101a")

    def test_empty_binary(self):
        # Test raising an exception for empty binary input
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("")
