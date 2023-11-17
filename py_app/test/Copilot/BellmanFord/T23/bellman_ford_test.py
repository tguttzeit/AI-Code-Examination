from py_app.src.Copilot.BellmanFord.T23.bellman_ford import BellmanFord

import unittest
import json


# Test graph was taken from main method: https://www.techiedelight.com/single-source-shortest-paths-bellman-ford
# -algorithm/


class BellmanFordTest(unittest.TestCase):

    @classmethod
    def setUpClass(self):
        self.json_all_positive_no_cycle = json.loads("{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{"
                                                     "\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{"
                                                     "\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}")
        self.json_all_positive_with_cycle = json.loads("{\"0\":{\"0\":0,\"1\":1,\"2\":4,\"3\":3,\"4\":3},\"1\":{"
                                                       "\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{\"2\":0},\"3\":{"
                                                       "\"1\":1,\"2\":4,\"3\":0,\"4\":3},\"4\":{\"1\":4,\"2\":7,"
                                                       "\"3\":3,\"4\":0}}")
        self.json_mixed_no_cycle = json.loads("{\"0\":{\"0\":0,\"1\":-1,\"2\":-1,\"3\":-6,\"4\":-3},\"1\":{\"1\":0,"
                                              "\"2\":0,\"3\":-5,\"4\":-2},\"2\":{\"2\":0},\"3\":{\"2\":5,\"3\":0},"
                                              "\"4\":{\"2\":2,\"3\":-3,\"4\":0}}")
        self.json_mixed_with_cycle = json.loads("{\"0\":{\"0\":0,\"1\":-1,\"2\":2,\"3\":-2,\"4\":1},\"1\":{\"1\":0,"
                                                "\"2\":3,\"3\":-1,\"4\":2},\"2\":{\"2\":0},\"3\":{\"1\":1,\"2\":4,"
                                                "\"3\":0,\"4\":3},\"4\":{\"1\":-2,\"2\":1,\"3\":-3,\"4\":0}}")
        self.json_one_lose_node = json.loads("{\"0\":{\"0\":0},\"1\":{\"1\":0,\"2\":3,\"3\":2,\"4\":2},\"2\":{"
                                             "\"2\":0},\"3\":{\"2\":5,\"3\":0},\"4\":{\"2\":8,\"3\":3,\"4\":0}}")

    def setUp(self):
        self.vertices = 5
        self.bf = BellmanFord(self.vertices)

    def test_bellman_ford_all_positive_no_cycle(self):
        self.bf.add_edge(0, 1, 1)
        self.bf.add_edge(0, 2, 4)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 3, 2)
        self.bf.add_edge(1, 4, 2)
        self.bf.add_edge(3, 2, 5)
        self.bf.add_edge(4, 3, 3)
        actual = json.dumps(self.generate_json_dict())
        expected = json.dumps(self.json_all_positive_no_cycle)
        self.assertEqual(expected, actual)

    def test_bellman_ford_all_positive_with_cycle(self):
        self.bf.add_edge(0, 1, 1)
        self.bf.add_edge(0, 2, 4)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 3, 2)
        self.bf.add_edge(1, 4, 2)
        self.bf.add_edge(3, 2, 5)
        self.bf.add_edge(3, 1, 1)
        self.bf.add_edge(4, 3, 3)
        actual = json.dumps(self.generate_json_dict())
        expected = json.dumps(self.json_all_positive_with_cycle)
        self.assertEqual(expected, actual)

    def test_bellman_ford_mixed_no_cycle(self):
        self.bf.add_edge(0, 1, -1)
        self.bf.add_edge(0, 2, 4)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 3, 2)
        self.bf.add_edge(1, 4, -2)
        self.bf.add_edge(3, 2, 5)
        self.bf.add_edge(4, 3, -3)
        actual = json.dumps(self.generate_json_dict())
        expected = json.dumps(self.json_mixed_no_cycle)
        self.assertEqual(expected, actual)

    def test_bellman_ford_mixed_with_cycle(self):
        self.bf.add_edge(0, 1, -1)
        self.bf.add_edge(0, 2, 4)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 3, 2)
        self.bf.add_edge(1, 4, 2)
        self.bf.add_edge(3, 1, 1)
        self.bf.add_edge(4, 3, -3)
        actual = json.dumps(self.generate_json_dict())
        expected = json.dumps(self.json_mixed_with_cycle)
        self.assertEqual(expected, actual)

    def test_bellman_ford_negative_cycle(self):
        self.bf.add_edge(0, 1, -1)
        self.bf.add_edge(0, 2, 4)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 4, -2)
        self.bf.add_edge(3, 2, 5)
        self.bf.add_edge(3, 1, 1)
        self.bf.add_edge(4, 3, -3)
        for source in range(self.vertices):
            result = self.bf.bellman_ford(source)
            if source != 2:
                self.assertIsNone(result)
            else:
                self.assertIsNotNone(result)

    def test_bellman_ford_one_lose_node(self):
        self.bf.add_edge(0, 0, 1)
        self.bf.add_edge(1, 2, 3)
        self.bf.add_edge(1, 3, 2)
        self.bf.add_edge(1, 4, 2)
        self.bf.add_edge(3, 2, 5)
        self.bf.add_edge(4, 3, 3)
        actual = json.dumps(self.generate_json_dict())
        expected = json.dumps(self.json_one_lose_node)
        self.assertEqual(expected, actual)

    # TODO: Add test for empty graph

    def generate_json_dict(self):
        results_dict = {}
        for source in range(self.vertices):
            source_result = self.bf.bellman_ford(source)
            # The path from and to the source is always 0.
            # This is manually added here, because this special case
            # was not considered in the prompt.
            source_result[source] = 0
            results_dict[source] = dict(sorted(source_result.items()))
        return results_dict


if __name__ == '__main__':
    unittest.main()
