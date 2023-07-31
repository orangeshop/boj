def solution(my_string):
    answer = ''
    my_string = my_string.replace('a',"")
    my_string = my_string.replace('e',"")
    my_string = my_string.replace('i',"")
    my_string = my_string.replace('o',"")
    answer = my_string.replace('u',"")
    
    return answer