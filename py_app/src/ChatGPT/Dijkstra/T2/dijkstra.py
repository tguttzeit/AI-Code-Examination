import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming the graph is undirected

    def find_shortest_paths(self, source):
        # Initialize the distance dictionary with infinity for all vertices except the source.
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Initialize the priority queue (min heap) with the source vertex and its distance.
        priority_queue = [(0, source)]

        # Initialize the result dictionary to store the shortest paths.
        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance from the priority queue.
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If the current distance is greater than the stored distance, skip this node.
            if current_distance > distances[current_vertex]:
                continue

            # Update the shortest paths to neighbors of the current vertex.
            for neighbor, weight in self.graph[current_vertex]:
                distance = current_distance + weight

                # If a shorter path is found, update the distance and add to the priority queue.
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))
                    shortest_paths[neighbor] = current_vertex

        return shortest_paths
