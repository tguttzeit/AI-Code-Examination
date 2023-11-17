from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T5.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_convert_to_decimal_1(self):
        self.assertEqual(self.converter.convert_to_decimal('0'), 0)

    def test_convert_to_decimal_2(self):
        self.assertEqual(self.converter.convert_to_decimal('1'), 1)

    def test_convert_to_decimal_3(self):
        self.assertEqual(self.converter.convert_to_decimal('100'), 4)

    def test_convert_to_decimal_4(self):
        self.assertEqual(self.converter.convert_to_decimal('1001'), 9)

    def test_convert_to_decimal_5(self):
        self.assertEqual(self.converter.convert_to_decimal('1010'), 10)

    def test_convert_to_decimal_6(self):
        self.assertEqual(self.converter.convert_to_decimal('1111'), 15)

    def test_convert_to_decimal_7(self):
        self.assertEqual(self.converter.convert_to_decimal('10101010'), 170)