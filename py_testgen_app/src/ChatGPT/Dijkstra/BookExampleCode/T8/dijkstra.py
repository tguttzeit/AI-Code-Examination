# Source: https://www.geeksforgeeks.org/python-program-for-dijkstras-shortest-path-algorithm-greedy-algo-7/

# Python program for Dijkstra's single
# source shortest path algorithm. The program is
# for adjacency matrix representation of the graph

class Dijkstra:

    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]

    # CHANGE FOR EXPERIMENT: Added method to construct the graph
    def add_edge(self, source, destination, weight):
        self.graph[source][destination] = weight

    # A utility function to find the vertex with
    # minimum distance value, from the set of vertices
    # not yet included in the shortest path tree
    def min_distance(self, dist, spt_set):

        # Initialize minimum distance for next node
        min_distance = 1e7
        min_index = 0
        # Search not nearest vertex not in the
        # shortest path tree
        for v in range(self.vertices):
            if dist[v] < min_distance and spt_set[v] == False:
                min_distance = dist[v]
                min_index = v

        return min_index

    # Function that implements Dijkstra's single source
    # shortest path algorithm for a graph represented
    # using adjacency matrix representation
    # Added destination parameter
    def find_shortest_paths(self, source):

        dist = [1e7] * self.vertices
        dist[source] = 0
        results_dict = {}
        spt_set = [False] * self.vertices
        parent = [-1] * self.vertices  # CHANGE FOR EXPERIMENT: Added to output the path

        for cout in range(self.vertices):

            # Pick the minimum distance vertex from
            # the set of vertices not yet processed.
            # u is always equal to src in first iteration
            u = self.min_distance(dist, spt_set)
            # Put the minimum distance vertex in the
            # shortest path tree
            spt_set[u] = True
            # Update dist value of the adjacent vertices
            # of the picked vertex only if the current
            # distance is greater than new distance and
            # the vertex in not in the shortest path tree
            for v in range(self.vertices):
                if (self.graph[u][v] > 0 and
                        spt_set[v] == False and
                        dist[v] > dist[u] + self.graph[u][v]):
                    dist[v] = dist[u] + self.graph[u][v]
                    parent[v] = u
            if dist[cout] < 1e7 and cout != source:
                results_dict[cout] = dist[cout]
        return results_dict

# This code is contributed by Divyanshu Mehta
