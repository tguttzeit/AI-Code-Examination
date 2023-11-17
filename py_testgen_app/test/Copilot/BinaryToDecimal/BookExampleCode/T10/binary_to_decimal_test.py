from py_testgen_app.src.Copilot.BinaryToDecimal.BookExampleCode.T10.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def setUp(self):
        self.btd = BinaryToDecimal()

    def test_convert_to_decimal(self):
        self.assertEqual(self.btd.convert_to_decimal('11111111'), 255)
        self.assertEqual(self.btd.convert_to_decimal('00000000'), 0)
        self.assertEqual(self.btd.convert_to_decimal('10101010'), 170)

    def tearDown(self):
        del self.btd