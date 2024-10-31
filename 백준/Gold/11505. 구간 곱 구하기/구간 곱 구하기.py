
div = 1000000007
def init(node, s, e):

    if s == e:
        tree[node] = a[s]
        return

    mid = (s + e) // 2

    init(node * 2, s, mid)
    init(node * 2 + 1, mid + 1, e)

    tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % div

def query(node ,s , e, l, r):

    if s > r or e < l:
        return 1

    if l <= s and e <= r:
        return tree[node]

    mid = (s + e) // 2
    L = query(node * 2, s, mid, l, r)
    R = query(node * 2 + 1, mid+1, e, l, r)
    result = (L * R) % div

    return result

def update(node, s, e, idx, val):

    if idx < s or e < idx:
        return

    if s == e:
        tree[node] = val
        return

    mid = (s + e) // 2
    update(node * 2, s, mid, idx, val)
    update(node * 2 + 1, mid + 1, e, idx, val)

    tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % div

N, M, K = map(int, input().split())

tree = [1 for _ in range(N * 4)]

a = [0 for _ in range(N + 1)]

for i in range(1, N+1):
    a[i] = int(input())

init(1,1, N)


for _ in range(M + K):

    a, b, c = map(int, input().split())

    if a == 1:
        update(1, 1, N, b, c)

    else:
        print(query(1, 1, N, b, c))