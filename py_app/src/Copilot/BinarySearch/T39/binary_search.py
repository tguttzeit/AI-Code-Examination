class BinarySearch:

  def binary_search(self, array, target):
    if len(array) == 0:
      return False
    else:
      midpoint = len(array) // 2
      if array[midpoint] == target:
        return True
      else:
        if array[midpoint] < target:
          return self.binary_search(array[midpoint + 1:], target)
        else:
          return self.binary_search(array[:midpoint], target)
