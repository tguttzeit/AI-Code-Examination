class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Step 1: fill the distance array and predecessor array
        distance = [float("Inf")] * self.vertices
        predecessor = [-1] * self.vertices
        distance[source] = 0

        # Step 2: relax edges |vertices| - 1 times
        for i in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight
                    predecessor[destination] = source

        # Step 3: detect negative cycle
        for source, destination, weight in self.graph:
            if distance[source] != float("Inf") and distance[source] + weight < distance[destination]:
                print("Graph contains negative weight cycle")
                return None

        # Step 4: print the distance and predecessor array
        return self.print_solution(distance, predecessor)

    def print_solution(self, distance, predecessor):
        print("Vertex Distance from Source")
        for i in range(self.vertices):
            print("{0}\t\t{1}\t\t{2}".format(i, distance[i], predecessor[i]))
