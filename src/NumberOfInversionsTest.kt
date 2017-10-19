import java.io.File
import java.io.InputStream

object NumberOfInversionsTest{
    var fourDescending = arrayOf(4, 3, 2, 1)
    var fourAscending = arrayOf(1, 2, 3, 4)
    var eightAscending = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var eightRandom = arrayOf(5, 7, 1, 2, 8, 3, 6, 4)
    var nonSquareTwo = arrayOf(5, 7, 1, 2, 8, 3)

    @JvmStatic
    fun main(args: Array<String>){
        test(fourDescending)
        test(fourAscending)
        test(eightAscending)
        test(eightRandom)
        //test(nonSquareTwo)

        var veryBigArray = arrayListOf<Int>()
        val inputStream: InputStream = File("src/integerarray.txt").inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{veryBigArray.add(it.toInt())}
        //test(veryBigArray.toTypedArray())
    }

    fun test(test: Array<Int>){
        for (i in NumberOfInversions.mergeSort(test)) {
            print(i.toString())
        }
        println()
    }
}