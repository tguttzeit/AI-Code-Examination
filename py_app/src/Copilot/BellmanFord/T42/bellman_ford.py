class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # initialize distance of all nodes as infinity except source node
        distance = [float("Inf")] * self.vertices
        distance[source] = 0

        # relax edges |V| - 1 times
        for i in range(self.vertices - 1):
            # update distance of all adjacent nodes of u
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # check for negative-weight cycles
        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                print("Graph contains negative weight cycle")
                return None

        # output the shortest path to every other node in the graph
        result = {}
        for i in range(self.vertices):
            if distance[i] != float("Inf"):
                result[i] = distance[i]
            else:
                result[i] = None
        return result