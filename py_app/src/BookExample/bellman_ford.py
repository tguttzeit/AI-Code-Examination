# Source: https://www.techiedelight.com/single-source-shortest-paths-bellman-ford-algorithm/

import sys


class BellmanFord:

    # CHANGE FOR EXPERIMENT: Added constructor to initialize the vertices
    def __init__(self, vertices):
        self.edges = []
        self.vertices = vertices

    # CHANGE FOR EXPERIMENT: Added method to add edges to the class
    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    # CHANGE FOR EXPERIMENT: This method is not used as we are not interested in the path.
    # Recursive function to print the path of a given vertex from source vertex
    def get_path(self, parent, vertex):
        if vertex < 0:
            return []
        return self.get_path(parent, parent[vertex]) + [vertex]

    # Function to run the Bellman–Ford algorithm from a given source
    def bellman_ford(self, source):
        # distance[] and parent[] stores the shortest path (least cost/path) info
        distance = [sys.maxsize] * self.vertices
        parent = [-1] * self.vertices
        # Added results dict
        results_dict = {}
        # Initially, all vertices except source vertex weight INFINITY and no parent
        distance[source] = 0

        # relaxation step (run V-1 times)
        for k in range(self.vertices - 1):
            # edge from `u` to `v` having weight `w`
            for (u, v, w) in self.edges:
                # if the distance to destination `v` can be shortened by taking edge (u, v)
                if distance[u] != sys.maxsize and distance[u] + w < distance[v]:
                    # update distance to the new lower value
                    distance[v] = distance[u] + w
                    # set v's parent as `u`
                    parent[v] = u

        # run relaxation step once more for n'th time to check for negative-weight cycles
        for (u, v, w) in self.edges:  # edge from `u` to `v` having weight `w`
            # if the distance to destination `u` can be shortened by taking edge (u, v)
            if distance[u] != sys.maxsize and distance[u] + w < distance[v]:
                print('Negative-weight cycle is found!!')
                return

        for i in range(self.vertices):
            if i != source and distance[i] < sys.maxsize:
                results_dict[i] = distance[i]
        return results_dict
