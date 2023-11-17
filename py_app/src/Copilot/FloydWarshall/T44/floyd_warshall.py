class FloydWarshall:
    def __init__(self, nodes):
        self.nodes = nodes
        self.distance = [[float("inf") for i in range(nodes)] for j in range(nodes)]
        self.next = [[float("inf") for i in range(nodes)] for j in range(nodes)]
        for i in range(nodes):
            self.distance[i][i] = 0
            self.next[i][i] = i
        print(self.distance)
        print(self.next)

    def add_edge(self, source, destination, weight):
        self.distance[source][destination] = weight
        self.next[source][destination] = destination

    def path(self, source, destination):
        if self.distance[source][destination] == float("inf"):
            return []
        path = [source]
        while source != destination:
            source = self.next[source][destination]
            path.append(source)
        return path

    def run(self):
        for k in range(self.nodes):
            for i in range(self.nodes):
                for j in range(self.nodes):
                    if self.distance[i][k] + self.distance[k][j] < self.distance[i][j]:
                        self.distance[i][j] = self.distance[i][k] + self.distance[k][j]
                        self.next[i][j] = self.next[i][k]
        print(self.distance)
        print(self.next)