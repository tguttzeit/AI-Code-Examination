class BinarySearch:

    def binary_search(self, target, numbers):
        if len(numbers) == 0:
            return False
        else:
            midpoint = len(numbers) // 2
            if numbers[midpoint] == target:
                return True
            else:
                if numbers[midpoint] < target:
                    return self.binary_search(target, numbers[midpoint + 1:])
                else:
                    return self.binary_search(target, numbers[:midpoint])
