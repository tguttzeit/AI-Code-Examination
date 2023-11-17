from py_testgen_app.src.ChatGPT.BinaryToDecimal.PromptOnly.T4.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):

    # Test case 1: Binary string '1101' should convert to decimal 13
    def test_binary_to_decimal_case1(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal('1101')
        self.assertEqual(result, 13)

    # Test case 2: Binary string '101010' should convert to decimal 42
    def test_binary_to_decimal_case2(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal('101010')
        self.assertEqual(result, 42)

    # Test case 3: Binary string '11111111' should convert to decimal 255
    def test_binary_to_decimal_case3(self):
        binary_converter = BinaryToDecimal()
        result = binary_converter.convert_to_decimal('11111111')
        self.assertEqual(result, 255)
