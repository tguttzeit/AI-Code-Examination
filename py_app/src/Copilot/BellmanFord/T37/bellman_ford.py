class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # initialize distance from source to all other vertices as infinity
        distance = [float("Inf")] * self.vertices
        # distance from source to itself is 0
        distance[source] = 0

        # relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            # update distance value and parent index of the adjacent vertices of the picked vertex
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # check for negative-weight cycles
        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                print("Graph contains negative-weight cycle")
                return None

        # print all distance
        output = {}
        for i in range(self.vertices):
            if distance[i] != float("Inf"):
                output[i] = distance[i]

        return output