import java.io.File
import java.io.InputStream

object NumberOfInversions {

    //var list = arrayOf("4", "3", "2", "1")

    //runtime: O(n logn)
    //1)base: 1 element array
    //2)recursion: sort and count left and right inversions
    //• left inversion i,j <= n/2, right inversion i,j > n/2, split i <= n/2, j > n/2
    //3)count split inversions when c array contains larger values than b array
    //• when element of 2nd array C gets copied to output D, increment total by num of elements remaining in B
    @JvmStatic
    fun main(args: Array<String>) {

        var list = arrayListOf<Int>()
        val inputStream: InputStream = File("src/integerarray.txt").inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{list.add(it.toInt())}
        print(list.size)
        //lineList.forEach{println(">  " + it)}

        //print(mergeSort(list))
        /*list.sort()
        for (i in list){
            print(i + " ")
        }*/
    }

    private fun mergeSort(list: Array<String>): Array<String> {
        if(list.size == 1){
            return sortedArray(list)
        } else {
            //todo: split list
            list.sort()
            //mergeSort()
            return list
        }
    }

    private fun sortedArray(list: Array<String>): Array<String> {
        if(list[0] > list[1]){
            var temp = list[0]
            return arrayOf(list[1], temp)
        } else {
            return list
        }
    }

}