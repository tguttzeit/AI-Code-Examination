from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T7.binary_to_decimal import BinaryToDecimal

import unittest


class BinaryToDecimalTest(unittest.TestCase):
    def test_convert_to_decimal_valid_binary(self):
        binary_converter = BinaryToDecimal()

        # Test with a valid binary input
        result = binary_converter.convert_to_decimal("1010")
        self.assertEqual(result, 10)

    def test_convert_to_decimal_invalid_binary(self):
        binary_converter = BinaryToDecimal()

        # Test with an invalid binary input (contains a non-binary character)
        with self.assertRaises(ValueError):
            binary_converter.convert_to_decimal("10102")

    def test_convert_to_decimal_empty_binary(self):
        binary_converter = BinaryToDecimal()

        # Test with an empty binary input
        with self.assertRaises(ValueError):
            binary_converter.convert_to_decimal("")

