n = int(input())

ls = list(map(int, input().split()))
ls.insert(0,0)
t = int(input())

for i in range(t):
    a, b = map(int ,input().split())
    # print(ls)
    if a == 1:
        num = 1
        for k in range(1, n+1):
            if k % b == 0:
                if(ls[k] == 1):
                    ls[k] = 0
                else:
                    ls[k] = 1

    elif a == 2:
        if ls[b] == 0:
            ls[b] = 1
        elif ls[b] == 1:
            ls[b] = 0

        for k in range(1, n+1):
            if(b-k < 1 or b + k > n):
                break
            if(ls[b-k] == ls[b + k]):
                if(ls[b-k] == 0):
                    ls[b - k] = 1
                    ls[b + k] = 1
                else:
                    ls[b - k] = 0
                    ls[b + k] = 0
            else:
                break

# ls.remove(0)
# print(ls)

for i in range(1, n+1):

    print(ls[i], end = '')

    if(i % 20 == 0 and i != 0):
        print()
    else:
        print(' ', end="")