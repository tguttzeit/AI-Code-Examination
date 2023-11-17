from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T7.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    # Test Case 1: 1/2
    def test_case_1(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(1, 2)
        expected = [2]
        self.assertEqual(result, expected)

    # Test Case 2: 1/3
    def test_case_2(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(1, 3)
        expected = [2, 6]
        self.assertEqual(result, expected)

    # Test Case 3: 1/4
    def test_case_3(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(1, 4)
        expected = [4]
        self.assertEqual(result, expected)

    # Test Case 4: 2/3
    def test_case_4(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(2, 3)
        expected = [2, 6]
        self.assertEqual(result, expected)

    # Test Case 5: 3/4
    def test_case_5(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(3, 4)
        expected = [2, 4]
        self.assertEqual(result, expected)

    # Test Case 6: 5/6
    def test_case_6(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(5, 6)
        expected = [2, 3, 18]
        self.assertEqual(result, expected)

    # Test Case 7: 7/8
    def test_case_7(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(7, 8)
        expected = [2, 8]
        self.assertEqual(result, expected)

    # Test Case 8: 9/10
    def test_case_8(self):
        egyptian_fractions = EgyptianFractions()
        result = egyptian_fractions.build(9,
