from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T1.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_valid_binary(self):
        binary = "1101"
        result = BinaryToDecimal.convert_to_decimal(binary)
        self.assertEqual(result, 13)

    def test_invalid_binary(self):
        binary = "1234"  # This is not a valid binary string
        result = BinaryToDecimal.convert_to_decimal(binary)
        self.assertIsNone(result)

    def test_empty_binary(self):
        binary = ""
        result = BinaryToDecimal.convert_to_decimal(binary)
        self.assertIsNone(result)



