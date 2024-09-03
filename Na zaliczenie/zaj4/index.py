# Obliczanie średnich indeksów zgodności dla tekstu zaszyfrowanego
import re
import string
def vigenere_encrypt(text, key):
    key_length = len(key)
    key_as_int = [ord(i) for i in key]
    plaintext_int = [ord(i) for i in text if i in string.ascii_letters]
    ciphertext = ''
    for i in range(len(plaintext_int)):
        value = (plaintext_int[i] + key_as_int[i % key_length]) % 26
        ciphertext += chr(value + 65)
    return ciphertext
def calculate_ic(text):
    N = len(text)
    frequency = {}
    for letter in text:
        frequency[letter] = frequency.get(letter, 0) + 1
    ic = 0
    for letter in frequency:
        ic += frequency[letter] * (frequency[letter] - 1)
    ic /= (N * (N - 1))
    return ic

def calculate_average_ic_for_groups(text, group_size):
    groups = ['' for _ in range(group_size)]
    for i, letter in enumerate(text):
        groups[i % group_size] += letter
    average_ic = sum(calculate_ic(group) for group in groups) / group_size
    return average_ic

path1 = "..\zaj3\encrypted.txt"
path2 = "..\zaj3\Pride_and_prejudice.txt"
with open(path2, "r", encoding="utf-8") as f:
    text = f.read()



#cleaned_text = re.sub("[^a-z]", "", text.upper())
key = "HEJO"
# Szyfrowanie tekstu
encrypted_text = vigenere_encrypt(text.replace(" ", "").upper(), key.upper())

# Obliczanie indeksu zgodności dla tekstu wzorcowego
ic_plain_text = calculate_ic(text.replace(" ", "").upper())

encrypted_text, ic_plain_text

# Obliczenia dla M od 2 do 20
average_ics = {}
for M in range(2, 20):
    average_ics[M] = calculate_average_ic_for_groups(encrypted_text, M)

average_ics
