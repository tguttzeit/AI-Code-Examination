from py_testgen_app.src.ChatGPT.EgyptianFractions.BookExampleCode.T6.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def test_case_1(self):
        ef = EgyptianFractions()
        result = ef.build(5, 7)
        self.assertEqual(result, [2, 3, 42])

    def test_case_2(self):
        ef = EgyptianFractions()
        result = ef.build(3, 4)
        self.assertEqual(result, [2, 4])

    def test_case_3(self):
        ef = EgyptianFractions()
        result = ef.build(7, 9)
        self.assertEqual(result, [2, 6, 18])


