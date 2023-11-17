from py_testgen_app.src.Copilot.BinaryToDecimal.PromptOnly.T1.binary_to_decimal import BinaryToDecimal

import unittest

class BinaryToDecimalTest(unittest.TestCase):
    def test_binary_to_decimal(self):
        # Arrange
        binary = "1001"
        expected = 9
        sut = BinaryToDecimal()
        # Act
        actual = sut.convert_to_decimal(binary)
        # Assert
        self.assertEqual(expected, actual)

    def test_binary_to_decimal(self):
        # Arrange
        binary = "100110"
        expected = 38
        sut = BinaryToDecimal()
        # Act
        actual = sut.convert_to_decimal(binary)
        # Assert
        self.assertEqual(expected, actual)

    def test_binary_to_decimal(self):
        # Arrange
        binary = "100001"
        expected = 33
        sut = BinaryToDecimal()
        # Act
        actual = sut.convert_to_decimal(binary)
        # Assert
        self.assertEqual(expected, actual)
