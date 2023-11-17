from py_testgen_app.src.Copilot.BinaryToDecimal.AIGenerated.T8.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_1(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('0'), 0)

    def test_2(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1'), 1)

    def test_3(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10'), 2)

    def test_4(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('11'), 3)

    def test_5(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('100'), 4)

    def test_6(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('101'), 5)

    def test_7(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('110'), 6)

    def test_8(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('111'), 7)

    def test_9(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1000'), 8)

    def test_10(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1001'), 9)

    def test_11(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1010'), 10)

    def test_12(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1011'), 11)

    def test_13(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1100'), 12)

    def test_14(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1101'), 13)

    def test_15(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1110'), 14)

    def test_16(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('1111'), 15)

    def test_17(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10000'), 16)

    def test_18(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10001'), 17)

    def test_19(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10010'), 18)

    def test_20(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10011'), 19)

    def test_21(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10100'), 20)

    def test_22(self):
        self.assertEqual(BinaryToDecimal.convert_to_decimal('10101'), 21)