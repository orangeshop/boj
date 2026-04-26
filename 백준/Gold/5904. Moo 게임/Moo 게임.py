N = int(input())

s = ['m','o','o']
def solve(depth, k, l):
    line = 2 * l + k + 3
    if depth <= 3:
        print(s[depth-1])
        exit(0)
    if line < depth:
        solve(depth, k+1, line)

    else:
        if depth > l and depth <= l +k +3:
            if depth - l != 1:
                print('o')
            else:
                print('m')
            exit(0)
        else:
            solve(depth-(l+k+3), 1, 3)

solve(N, 1, 3)