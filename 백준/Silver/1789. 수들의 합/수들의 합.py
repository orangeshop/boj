num = int(input())
answer = 0
for i in range(1, 4294967295):
    answer += i
    if(answer > num):
        print(i -1)
        break