import matplotlib.pyplot as plt


def visualize_eratosthenes(n):
    sieve = [True] * n
    sieve[0], sieve[1] = False, False
    data = [sieve.copy()]
    for start in range(2, int(n**0.5) + 1):
        if sieve[start]:
            for i in range(start*start, n, start):
                sieve[i] = False
                data.append(sieve.copy())

    fig, ax = plt.subplots(figsize=(10, len(data) // n * 10))
    ax.imshow(data, cmap="Greys", aspect="auto")
    ax.set_xlabel("Indeksy")
    ax.set_ylabel("Iteracje")
    plt.show()

# Przykład wizualizacji
visualize_eratosthenes(100)