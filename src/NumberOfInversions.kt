import java.io.File
import java.io.InputStream

object NumberOfInversions {
    //todo: Count Inversions With MergeSort
    //runtime: O(n logn)
    //1)base: 1 element array
    //2)recursion: sort and count left and right inversions
    //• left inversion i,j <= n/2, right inversion i,j > n/2, split i <= n/2, j > n/2
    //3)count split inversions when c array contains larger values than b array
    //• when element of 2nd array C gets copied to output D, increment total by num of elements remaining in B
    var numOfInversions = 0

    fun mergeSort(list: Array<Int>): Array<Int> {
        if (list.size == 1) {
            return list
        }
        if (list.size == 2) {
            return sortedArray(list)
        } else {
            var splitArray = getSplitArray(list)
            var i = 0
            var j = 0
            var sortedList = arrayListOf<Int>()

            for (x in 0..list.size - 1) {
                if (i < splitArray.first.size && j < splitArray.second.size) {
                    if (splitArray.first[i] < splitArray.second[j]) {
                        sortedList.add(splitArray.first[i])
                        i++
                    } else {
                        sortedList.add(splitArray.second[j])
                        j++
                    }
                }
                if (j == splitArray.second.size && i < splitArray.first.size) {
                    sortedList.add(splitArray.first[i])
                    i++
                }
                if (i == splitArray.first.size && j < splitArray.second.size) {
                    sortedList.add(splitArray.second[j])
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

    private fun getSplitArray(list: Array<Int>): Pair<Array<Int>, Array<Int>>
            = Pair(mergeSort(list.copyOfRange(0, list.size / 2)), mergeSort(list.copyOfRange(list.size / 2, list.size)))



}