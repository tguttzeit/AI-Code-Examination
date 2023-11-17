class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append([destination, weight])

    def find_shortest_paths(self, source):
        # Initialize distances
        distances = [float('inf')] * self.vertices
        distances[source] = 0

        # Initialize priority queue
        queue = []
        queue.append([source, 0])

        while len(queue) > 0:
            # Get current node
            current = queue.pop(0)

            # Get current node's neighbors
            for neighbor in self.graph[current[0]]:
                # Calculate distance to neighbor
                distance = distances[current[0]] + neighbor[1]

                # If distance is less than current distance, update distance and add to queue
                if distance < distances[neighbor[0]]:
                    distances[neighbor[0]] = distance
                    queue.append([neighbor[0], distance])

        # Initialize output
        output = {}

        # Iterate through distances
        for i in range(len(distances)):
            # If distance is not infinity, add to output
            if distances[i] != float('inf'):
                output[i] = distances[i]

        return output
