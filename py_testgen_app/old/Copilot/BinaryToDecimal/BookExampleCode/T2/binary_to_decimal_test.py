from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T2.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):

    def test_convert_to_decimal_1(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('0'), 0)

    def test_convert_to_decimal_2(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1'), 1)

    def test_convert_to_decimal_3(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('10'), 2)

    def test_convert_to_decimal_4(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('11'), 3)

    def test_convert_to_decimal_5(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('100'), 4)

    def test_convert_to_decimal_6(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('101'), 5)

    def test_convert_to_decimal_7(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('110'), 6)

    def test_convert_to_decimal_8(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('111'), 7)

    def test_convert_to_decimal_9(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1000'), 8)

    def test_convert_to_decimal_10(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1001'), 9)

    def test_convert_to_decimal_11(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1010'), 10)

    def test_convert_to_decimal_12(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1011'), 11)

    def test_convert_to_decimal_13(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1100'), 12)

    def test_convert_to_decimal_14(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1101'), 13)

    def test_convert_to_decimal_15(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal('1110'), 14)

    def test_convert_to_decimal_16(self):
        b