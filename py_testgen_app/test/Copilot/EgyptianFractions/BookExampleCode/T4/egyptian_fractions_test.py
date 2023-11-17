from py_testgen_app.src.Copilot.EgyptianFractions.BookExampleCode.T4.egyptian_fractions import EgyptianFractions

import unittest

class EgyptianFractionsTest(unittest.TestCase):

    def test_case_1(self):
        # Arrange
        egyptian_fractions = EgyptianFractions()

        # Act
        result = egyptian_fractions.build(3, 7)

        # Assert
        self.assertEqual(2, len(result))
        self.assertEqual(1, result[0])
        self.assertEqual(3, result[1])

    def test_case_2(self):
        # Arrange
        egyptian_fractions = EgyptianFractions()

        # Act
        result = egyptian_fractions.build(2, 3)

        # Assert
        self.assertEqual(2, len(result))
        self.assertEqual(1, result[0])
        self.assertEqual(3, result[1])

    def test_case_3(self):
        # Arrange
        egyptian_fractions = EgyptianFractions()

        # Act
        result = egyptian_fractions.build(6, 14)

        # Assert
        self.assertEqual(3, len(result))
        self.assertEqual(1, result[0])
        self.assertEqual(2, result[1])
        self.assertEqual(7, result[2])
