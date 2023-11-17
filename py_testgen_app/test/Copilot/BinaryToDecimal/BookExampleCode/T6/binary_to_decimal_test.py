from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T6.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_1(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("111"), 7)

    def test_2(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("101"), 5)

    def test_3(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1011"), 11)

    def test_4(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1001"), 9)

    def test_5(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1101"), 13)

    def test_6(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1111"), 15)

    def test_7(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1100"), 12)

    def test_8(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1110"), 14)

    def test_9(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1010"), 10)

    def test_10(self):
        btd = BinaryToDecimal()
        self.assertEqual(btd.convert_to_decimal("1000"), 8)
