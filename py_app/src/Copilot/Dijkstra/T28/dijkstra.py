class Dijkstra:

    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}

    def add_edge(self, source, destination, weight):
        if source not in self.graph:
            self.graph[source] = [(destination, weight)]
        else:
            self.graph[source].append((destination, weight))

    def find_shortest_paths(self, source):
        dist = {node: float('inf') for node in range(1, self.vertices + 1)}
        dist[source] = 0
        visited = set()
        path = []

        while len(visited) < self.vertices:
            min_node = None
            for node in range(1, self.vertices + 1):
                if node not in visited and (min_node is None or dist[node] < dist[min_node]):
                    min_node = node

            if min_node is None:
                break

            visited.add(min_node)
            path.append(min_node)

            for neighbour, weight in self.graph[min_node]:
                if dist[min_node] + weight < dist[neighbour]:
                    dist[neighbour] = dist[min_node] + weight

        return dist