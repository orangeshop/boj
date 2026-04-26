
class Node:
    def __init__(self):
        self.valid = False
        self.child = {}

def init():
    x = Node()
    Trie.append(x)
    return len(Trie)-1


def solve(nd, S, idx):

    if idx == len(S):
        Trie[nd].valid = True
        return True

    if Trie[nd].valid:
        return False

    c = S[idx]
    if c not in Trie[nd].child:
        Trie[nd].child[c] = init()

    return solve(Trie[nd].child[c], S, idx + 1)

Trie = []

T = int(input())

for _ in range(T):
    Trie.clear()
    init()
    N = int(input())

    ls = []

    for _ in range(N):
        ls.append(input())

    ls = sorted(ls)


    ans = True
    for item in ls:
        if not solve(0, item, 0):
            ans = False
            break


    if ans == True:
        print("YES")
    else:
        print("NO")
