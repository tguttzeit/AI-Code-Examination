from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T8.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def setUp(self):
        self.converter = BinaryToDecimal()

    def test_convert_to_decimal(self):
        self.assertEqual(self.converter.convert_to_decimal('0'), 0)
        self.assertEqual(self.converter.convert_to_decimal('1'), 1)
        self.assertEqual(self.converter.convert_to_decimal('10'), 2)
        self.assertEqual(self.converter.convert_to_decimal('11'), 3)
        self.assertEqual(self.converter.convert_to_decimal('100'), 4)
        self.assertEqual(self.converter.convert_to_decimal('101'), 5)
        self.assertEqual(self.converter.convert_to_decimal('110'), 6)
        self.assertEqual(self.converter.convert_to_decimal('111'), 7)
        self.assertEqual(self.converter.convert_to_decimal('1000'), 8)
        self.assertEqual(self.converter.convert_to_decimal('1001'), 9)
        self.assertEqual(self.converter.convert_to_decimal('1010'), 10)
        self.assertEqual(self.converter.convert_to_decimal('1011'), 11)
        self.assertEqual(self.converter.convert_to_decimal('1100'), 12)
        self.assertEqual(self.converter.convert_to_decimal('1101'), 13)
        self.assertEqual(self.converter.convert_to_decimal('1110'), 14)
        self.assertEqual(self.converter.convert_to_decimal('1111'), 15)
        self.assertEqual(self.converter.convert_to_decimal('10000'), 16)
        self.assertEqual(self.converter.convert_to_decimal('10001'), 17)
        self.assertEqual(self.converter.convert_to_decimal('10010'), 18)
        self.assertEqual(self.converter.convert_to_decimal('10011'), 19)
        self.assertEqual(self.converter.convert_to_decimal('10100'), 20)
        self.assertEqual(self.converter.convert_to_decimal('10101'), 21)
        self.assertEqual(self.converter.convert_to_decimal('10110'), 22)
        self.assertEqual(self.converter.convert_to_decimal('10111'), 23)
        self.assertEqual(self.converter.convert_to_decimal('11000'), 24)
        self.assertEqual(self.converter.convert_to_decimal('11001'), 25)
        self.assertEqual(self.converter.convert_to_decimal('11010'), 26)
        self.assertEqual(self.converter.convert_to_decimal('11011'), 27)
        self.assertEqual(self.converter.convert_to_decimal('11100'), 28)
        self.assertEqual(self.converter.convert_to_decimal('11101'), 29)
        self.assertEqual(self.converter.convert_to_decimal('11110'), 30)
        self.assertEqual(self.converter.convert_to_decimal('11111'), 31)