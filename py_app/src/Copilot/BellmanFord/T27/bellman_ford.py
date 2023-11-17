class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        distance = [float("Inf")] * self.vertices
        distance[source] = 0

        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                return None

        return self.print_solution(distance)

    def print_solution(self, distance):
        print("Vertex Distance from Source")
        for node in range(self.vertices):
            print(f"{node} \t\t {distance[node]}")