class Solution {
    fun solution(common: IntArray): Int {
        var answer: Int = 0
        
        println(common)
        
        var ls = arrayListOf<Int>()
        var result = mutableSetOf<Int>()
        
        // for(i in 0 until 10){
        //     println(i)
        // }
        
        for (i in 1 until common.size){
            result.add(common[i] - common[i-1])
        }

       println(result)

        var transSet = mutableListOf<Int>()
        for(i in result){
            transSet.add(i)
        }

        if(result.size == 1){
            answer = common[common.lastIndex] + transSet[0]
        }
        else{
            answer = common[common.lastIndex] * (transSet[1] / transSet[0])
        }
        println(answer)
        return answer
    }
}