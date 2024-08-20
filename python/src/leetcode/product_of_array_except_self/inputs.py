def get_input(filename):
    with open(filename, 'r') as f:
        res = f.read()
        return res.strip().split(",")


inp = get_input("inputs/extra-large.txt")
