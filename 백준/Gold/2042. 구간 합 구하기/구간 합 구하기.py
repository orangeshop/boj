
def init(node, s, e):
    if s == e:
        Tree[node] = a[s]
        return

    mid = (s + e) // 2

    init(node * 2, s, mid)
    init(node * 2 + 1, mid + 1 ,e)
    Tree[node] = Tree[node * 2] + Tree[node * 2 + 1]

def query(node, s, e, i, j):
    if s > j or e < i:
        return 0

    if i <= s and e <= j:
        return Tree[node]

    mid = (s + e) // 2
    L = query(node * 2, s, mid, i, j)
    R = query(node * 2 + 1, mid + 1, e, i, j)

    return L + R


def update(node, s, e, idx, val):

    if idx < s or e < idx:
        return

    if s == e:
        Tree[node] = val
        return

    mid = (s + e) // 2
    update(node * 2, s, mid, idx, val)
    update(node * 2 + 1, mid + 1, e, idx, val)
    Tree[node] = Tree[node * 2] + Tree[node * 2 + 1]


N, M, K = map(int, input().split())

Tree = [0 for _ in range(N * 5)]

a = [0 for _ in range(N+1)]



for i in range(1, N+1):
    a[i] = int(input())

init(1,1, N)

for _ in range(M + K):
    a, b, c = map(int, input().split())

    if a == 1:
        update(1, 1, N, b,c)

    else:
        print(query(1,1,N, b,c))
