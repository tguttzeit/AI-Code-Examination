from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T4.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_convert_to_decimal_1(self):
        decimal = self.converter.convert_to_decimal('1001')
        self.assertEqual(decimal, 9)

    def test_convert_to_decimal_2(self):
        decimal = self.converter.convert_to_decimal('1010')
        self.assertEqual(decimal, 10)

    def test_convert_to_decimal_3(self):
        decimal = self.converter.convert_to_decimal('1011')
        self.assertEqual(decimal, 11)

    def test_convert_to_decimal_4(self):
        decimal = self.converter.convert_to_decimal('1100')
        self.assertEqual(decimal, 12)

    def test_convert_to_decimal_5(self):
        decimal = self.converter.convert_to_decimal('1101')
        self.assertEqual(decimal, 13)

    def test_convert_to_decimal_6(self):
        decimal = self.converter.convert_to_decimal('1110')
        self.assertEqual(decimal, 14)

    def test_convert_to_decimal_7(self):
        decimal = self.converter.convert_to_decimal('1111')
        self.assertEqual(decimal, 15)

    def test_convert_to_decimal_8(self):
        decimal = self.converter.convert_to_decimal('10000')
        self.assertEqual(decimal, 16)

    def test_convert_to_decimal_9(self):
        decimal = self.converter.convert_to_decimal('10001')
        self.assertEqual(decimal, 17)

    def test_convert_to_decimal_10(self):
        decimal = self.converter.convert_to_decimal('10010')
        self.assertEqual(decimal, 18)

    def test_convert_to_decimal_11(self):
        decimal = self.converter.convert_to_decimal('10011')
        self.assertEqual(decimal, 19)

    def test_convert_to_decimal_12(self):
        decimal = self.converter.convert_to_decimal('10100')
        self.assertEqual(decimal, 20)

    def test_convert_to_decimal_13(self):
        decimal = self.converter.convert_to_decimal('10101')
        self.assertEqual(decimal, 21)

    def test_convert_to_decimal_14(self):
        decimal = self.converter.convert_to_decimal('10110')
        self.assertEqual(decimal, 22)

    def test_convert_to_decimal_15(self):
        decimal = self.converter.convert_to_decimal('10111')
        self.assertEqual(decimal, 23)

    def test_convert_to_decimal_16(self):
        decimal = self.converter.convert_to_decimal('11000')
        self.assertEqual(decimal, 24)

    def test_convert_to_decimal(self):
        x=0