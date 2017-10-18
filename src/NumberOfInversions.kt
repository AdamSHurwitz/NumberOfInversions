import java.io.File
import java.io.InputStream

object NumberOfInversions {

    var list = arrayOf(4, 3, 2, 1)
    var numOfInversions = 0

    //runtime: O(n logn)
    //1)base: 1 element array
    //2)recursion: sort and count left and right inversions
    //• left inversion i,j <= n/2, right inversion i,j > n/2, split i <= n/2, j > n/2
    //3)count split inversions when c array contains larger values than b array
    //• when element of 2nd array C gets copied to output D, increment total by num of elements remaining in B
    @JvmStatic
    fun main(args: Array<String>) {

        /*var list = arrayListOf<Int>()
        val inputStream: InputStream = File("src/integerarray.txt").inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{list.add(it.toInt())}*/

        var sortedList = mergeSort(list)

        for (i in sortedList) {
            print(i.toString())
        }

        println()
        print("Inversions: " + numOfInversions)
    }

    private fun mergeSort(list: Array<Int>): Array<Int> {
        if (list.size == 2) {
            return sortedArray(list)
        } else {
            var firstHalf = mergeSort(list.copyOfRange(0, list.size / 2))
            var secondHalf = mergeSort(list.copyOfRange(list.size / 2, list.size))
            var i = 0
            var j = 0
            var sortedList = arrayListOf<Int>()
            while (i < firstHalf.size && j < secondHalf.size) {
                if (secondHalf[j] < firstHalf[i]) {
                    //todo: count inversion
                    sortedList.add(secondHalf[j])
                    j++
                } else {
                    sortedList.add(firstHalf[i])
                    sortedList.add(secondHalf[j])
                    i++
                    j++
                }
            }
            return sortedList.toTypedArray()
        }
    }

    private fun sortedArray(list: Array<Int>): Array<Int> {
        if (list[1] < list[0]) {
            //todo: count inversion
            return arrayOf(list[1], list[0])
        } else {
            return list
        }
    }

}