from py_testgen_app.src.Copilot.BinarySearch.AIGenerated.T1.binary_search import BinarySearch

import unittest
class BinarySearchTest(unittest.TestCase):
    def test_binary_search(self):
        bs = BinarySearch()

        # test case 1
        nums = [1, 2, 3, 4, 5, 6, 7]
        target = 5
        expected = True
        actual = bs.binary_search(target, nums)
        self.assertEqual(expected, actual)

        # test case 2
        nums = [1, 2, 3, 4, 5, 6, 7]
        target = 8
        expected = False
        actual = bs.binary_search(target, nums)
        self.assertEqual(expected, actual)

        # test case 3
        nums = [1, 2, 3, 4, 5, 6, 7]
        target = 2
        expected = True
        actual = bs.binary_search(target, nums)
        self.assertEqual(expected, actual)
