def solution(numbers):
    answer = ''
    
    for i in range(len(numbers)-2):
        if(numbers[i] == 'z' and numbers[i+1] == 'e' and numbers[i+2] == 'r' and numbers[i+3] == 'o'):
            answer += '0'
        elif(numbers[i] == 'o' and numbers[i+1] == 'n' and numbers[i+2] == 'e' ):
            answer += '1'
        elif(numbers[i] == 't' and numbers[i+1] == 'w' and numbers[i+2] == 'o'):
            answer += '2'
        elif(numbers[i] == 't' and numbers[i+1] == 'h' and numbers[i+2] == 'r' and numbers[i+3] == 'e' and numbers[i+4] == 'e'):
            answer += '3'
        elif(numbers[i] == 'f' and numbers[i+1] == 'o' and numbers[i+2] == 'u' and numbers[i+3] == 'r'):
            answer += '4'
        elif(numbers[i] == 'f' and numbers[i+1] == 'i' and numbers[i+2] == 'v' and numbers[i+3] == 'e'):
            answer += '5'
        elif(numbers[i] == 's' and numbers[i+1] == 'i' and numbers[i+2] == 'x'):
            answer += '6'
            i += 2
        elif(numbers[i] == 's' and numbers[i+1] == 'e' and numbers[i+2] == 'v' and numbers[i+3] == 'e' and numbers[i+4] == 'n'):
            answer += '7'
        elif(numbers[i] == 'e' and numbers[i+1] == 'i' and numbers[i+2] == 'g' and numbers[i+3] == 'h' and numbers[i+4] == 't'):
            answer += '8'
        elif(numbers[i] == 'n' and numbers[i+1] == 'i' and numbers[i+2] == 'n' and numbers[i+3] == 'e'):
            answer += '9'
    return int(answer)