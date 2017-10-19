import java.io.File
import java.io.InputStream

object NumberOfInversionsTest{
    var fourDescending = arrayOf(4, 3, 2, 1)
    var fourAscending = arrayOf(1, 2, 3, 4)
    var eightAscending = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var eightRandom = arrayOf(5, 7, 1, 2, 8, 3)
    var nonSquareTwo = arrayOf(5, 1000, 7, 1, 2, 8, 3, 4, 11)
    var weekTwoExample = arrayOf(1, 3, 5, 2, 4, 6)

    @JvmStatic
    fun main(args: Array<String>){
        test(fourDescending)
        test(fourAscending)
        test(eightAscending)
        test(eightRandom)
        test(nonSquareTwo)
        test(weekTwoExample)

        var veryBigArray = arrayListOf<Int>()
        val inputStream: InputStream = File("src/integerarray.txt").inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{veryBigArray.add(it.toInt())}
        test(veryBigArray.toTypedArray())
    }

    fun test(test: Array<Int>){
        for (i in NumberOfInversions.mergeSort(test)) {
            print(i.toString())
        }
        NumberOfInversions.numOfInversions = 0
        println()
        NumberOfInversions.mergeSort(test)
        println("Number of Inversions: " + NumberOfInversions.numOfInversions)
        NumberOfInversions.numOfInversions = 0
    }
}