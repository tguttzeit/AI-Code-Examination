from py_testgen_app.src.ChatGPT.BinaryToDecimal.AIGenerated.T6.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_valid_binary_conversion(self):
        binary = "1010"
        decimal = self.converter.convert_to_decimal(binary)
        self.assertEqual(decimal, 10)

    def test_invalid_binary_input(self):
        binary = "1234"
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)

    def test_empty_binary_input(self):
        binary = ""
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal(binary)
