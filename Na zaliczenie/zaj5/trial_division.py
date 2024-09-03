def trial_division(n):
    if n <= 1:
        return []
    factors = []
    divisor = 2
    while divisor * divisor <= n:
        while (n % divisor) == 0:
            factors.append(divisor)
            n //= divisor
        divisor += 1
    if n > 1:
        factors.append(n)
    return factors

# Przykład użycia funkcji
number = 4705226898978889897897
print(f"Faktoryzacja liczby {number} to: {trial_division(number)}")