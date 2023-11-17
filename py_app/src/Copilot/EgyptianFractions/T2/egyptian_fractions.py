class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        """Builds the egyptian fraction for the given numerator and denominator.

        Args:
            numerator (long): The numerator.
            denominator (long): The denominator.

        Returns:
            list: The egyptian fraction list.
        """
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]

        fraction = []
        while numerator > 0:
            x = (denominator + numerator - 1) // numerator
            fraction.append(x)
            numerator = x * numerator - denominator
            denominator *= x
        return fraction