class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = [[float('inf')] * nodes for _ in range(nodes)]
        for i in range(nodes):
            self.graph[i][i] = 0

    def add_edge(self, source, destination, weight):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")
        self.graph[source][destination] = weight

    def path(self, source, destination):
        if source < 0 or source >= self.nodes or destination < 0 or destination >= self.nodes:
            raise ValueError("Invalid source or destination node")

        dist = [[float('inf')] * self.nodes for _ in range(self.nodes)]
        next_hop = [[-1] * self.nodes for _ in range(self.nodes)]

        # Initialize dist and next_hop matrices with the current graph
        for i in range(self.nodes):
            for j in range(self.nodes):
                dist[i][j] = self.graph[i][j]
                if i != j and self.graph[i][j] != float('inf'):
                    next_hop[i][j] = i

        # Floyd-Warshall algorithm
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        next_hop[i][j] = next_hop[k][j]

        # Reconstruct the path from source to destination
        path = []
        current_node = source
        while current_node != destination:
            if next_hop[current_node][destination] == -1:
                return []  # No path exists
            path.append(current_node)
            current_node = next_hop[current_node][destination]
        path.append(destination)

        return path

    def run(self):
        # Floyd-Warshall algorithm implementation
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.graph[i][k] + self.graph[k][j] < self.graph[i][j]:
                        self.graph[i][j] = self.graph[i][k] + self.graph[k][j]
