
class Node:
    def __init__(self):
        self.valid = False
        self.child = {}


trie = []

def init():
    x = Node()
    trie.append(x)
    return len(trie)-1

def add(node, s, idx):

    if len(s) == idx:
        trie[node].valid = True
        return True

    c = s[idx]

    if c not in trie[node].child:
        trie[node].child[c] = init()

    return add(trie[node].child[c], s, idx + 1)


def solve(node, s, idx):

    if len(s) == idx and trie[node].valid:
        return True

    if len(s) == idx:
        return False

    # if trie[node].valid:
    #     return False

    c = s[idx]

    if c not in trie[node].child:
        return False

    return solve(trie[node].child[c], s, idx + 1)




N, M = map(int, input().split())

nls = []

init()

for _ in range(N):
    add(0, input(), 0)

ans = 0

for _ in range(M):
    if solve(0, input(), 0):
        ans += 1




print(ans)