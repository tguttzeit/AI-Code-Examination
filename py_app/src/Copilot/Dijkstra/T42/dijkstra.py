class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}
        self.distance = {}
        self.visited = set()
        self.unvisited = set()
        for i in range(vertices):
            self.graph[i] = []
            self.distance[i] = float("inf")
            self.unvisited.add(i)

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))

    def find_shortest_paths(self, source):
        self.distance[source] = 0
        while self.unvisited:
            node = self.min_distance()
            self.unvisited.remove(node)
            self.visited.add(node)
            for neighbour in self.graph[node]:
                if neighbour[0] not in self.visited:
                    self.distance[neighbour[0]] = min(self.distance[neighbour[0]], self.distance[node] + neighbour[1])
        return self.distance

    def min_distance(self):
        min_distance = float("inf")
        min_node = None
        for node in self.unvisited:
            if self.distance[node] < min_distance:
                min_distance = self.distance[node]
                min_node = node
        return min_node