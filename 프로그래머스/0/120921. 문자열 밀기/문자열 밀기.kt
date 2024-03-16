class Solution {
    fun solution(A: String, B: String): Int {
        var answer: Int = -1
        var tmp = mutableListOf<Char>()



        for(i in 0 until A.length){
            tmp.add(A[i])
        }
//        println(tmp)
        for(i in 0 until A.length){


            var tmpStr:String = ""

            for(k in 0 until A.length){
                tmpStr += tmp[k]
            }
//            println(tmpStr+" "+ B)
            if(tmpStr == B){
                return i
            }

            tmp.add(0, tmp[tmp.lastIndex])
            tmp.removeAt(tmp.lastIndex)

        }


        return answer
    }
}