from py_testgen_app.src.Copilot.EgyptianFractions.AIGenerated.T9.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):
    def setUp(self):
        self.testObj = EgyptianFractions()

    def test_one(self):
        self.assertEqual(self.testObj.build(6, 14), [3, 11, 231])

    def test_two(self):
        self.assertEqual(self.testObj.build(2, 3), [2, 6])

    def test_three(self):
        self.assertEqual(self.testObj.build(12, 13), [2, 3, 12, 156])

    def tearDown(self):
        self.testObj = None
