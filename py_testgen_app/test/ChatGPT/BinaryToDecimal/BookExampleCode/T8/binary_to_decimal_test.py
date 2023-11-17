from py_testgen_app.src.ChatGPT.BinaryToDecimal.BookExampleCode.T8.binary_to_decimal import BinaryToDecimal

import unittest

class TestBinaryToDecimal(unittest.TestCase):

    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_binary_to_decimal(self):
        # Test case 1: Binary '101' should be converted to decimal 5
        self.assertEqual(self.converter.convert_to_decimal("101"), 5)

        # Test case 2: Binary '1101' should be converted to decimal 13
        self.assertEqual(self.converter.convert_to_decimal("1101"), 13)

        # Test case 3: Binary '11111111' should be converted to decimal 255
        self.assertEqual(self.converter.convert_to_decimal("11111111"), 255)

    def test_invalid_input(self):
        # Test case 4: Invalid binary input '102' should raise a ValueError
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("102")

        # Test case 5: Invalid binary input '1010102' should raise a ValueError
        with self.assertRaises(ValueError):
            self.converter.convert_to_decimal("1010102")
