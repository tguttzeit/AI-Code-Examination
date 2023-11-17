# Source: https://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/
# import math package to use ceiling function

import math


# wrapped class around the function
class EgyptianFractions:

    def build(self, numerator, denominator):
        # empty list egyptian_fractions to store denominator
        egyptian_fractions = []

        # while loop runs until fraction becomes 0 i.e, numerator becomes 0
        while numerator != 0:
            # taking ceiling
            x = math.ceil(denominator / numerator)

            # storing value in egyptian_fractions list
            # added 1/x to egyptian_fractions
            egyptian_fractions.append(1 / x)

            # updating new nr and dr
            numerator = x * numerator - denominator
            denominator = denominator * x

        # CHANGE FOR EXPERIMENT: Added return statement
        return egyptian_fractions
