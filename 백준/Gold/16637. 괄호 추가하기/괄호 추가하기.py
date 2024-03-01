from collections import deque


def makeNumberLs(depth, end, result, totalResult):

    totalResult.append(result[:])

    for i in range(depth, end + 1, 2):
        result.append(i)
        makeNumberLs(i + 4, end, result, totalResult)
        result.pop()


def clac(numberStr, totalResult):
    numQ = deque()  # 숫자 스택
    tmpQ = deque() # 기호 스택
    flag = -1
    for i in range(len(numberStr)):
        if (i in totalResult) == True:
            tmpQ.append("(")
            tmpQ.append(numberStr[i])
            flag = 1
            continue

        elif 0 <= ord(numberStr[i]) -48 and ord(numberStr[i]) - 48 <= 9:
            numQ.append(ord(numberStr[i]) -48)
            flag -= 1


        elif flag == 0:
            while((len(tmpQ) != 0)):
                if len(tmpQ) == 0:
                    break
                if tmpQ[len(tmpQ)-1] == "(":
                    tmpQ.pop()
                    continue



                numQ.append(tmpQ.pop())
            tmpQ.append(numberStr[i])
            flag -= 1
        else:

            if len(tmpQ) >= 1:
                numQ.append(tmpQ.pop())

            tmpQ.append(numberStr[i])

    # print(len(tmpQ))
    while((len(tmpQ) != 0)):

        if tmpQ[len(tmpQ)-1] == "(":
            tmpQ.pop()
            continue

        numQ.append(tmpQ.pop())

    # print("tmp Q", tmpQ)
    # print(numQ)
    return makeNumStack(numQ)

def makeNumStack(ls):
    resultls = deque()

    for i in range(len(ls)):
        # print(resultls)
        if ls[i] == "+" or ls[i] == "-" or ls[i] == "*":
            if len(resultls) >= 2:
                num1 = resultls.pop()
                num2 = resultls.pop()

                if ls[i] == "+":
                    resultls.append(num1 + num2)
                elif ls[i] == "-":
                    resultls.append(num2 - num1)
                elif ls[i] == "*":
                    resultls.append(num1 * num2)

        elif (0 <= ls[i] and ls[i] <= 9) == True:
            resultls.append(ls[i])
            continue


    return resultls.pop()




N = int(input())

numberStr = input()

totalResult = []
result = []
end = N - 2
answer = -999999999999999

makeNumberLs(1, end, result, totalResult)

# print(totalResult)

for i in range(0,len(totalResult)):
    answer = max(clac(numberStr, totalResult[i]), answer)



print(answer)
