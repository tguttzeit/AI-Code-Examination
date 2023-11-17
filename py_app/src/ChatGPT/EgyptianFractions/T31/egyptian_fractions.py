class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        result = []
        
        while numerator > 0:
            # Find the smallest positive integer x such that 1/x is less than or equal to the current fraction.
            x = denominator // numerator + 1
            
            # Append the Egyptian fraction 1/x to the result list.
            result.append(x)
            
            # Update the numerator and denominator.
            numerator = numerator * x - denominator
            denominator = denominator * x
        
        return result
