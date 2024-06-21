package binarySearch

import kotlin.math.max
import kotlin.math.min


/**
 *
 */
fun findMedianSortedArraysOptimal(nums1: IntArray, nums2: IntArray): Double {
    println("******************OPTIMAL *****************")
    val n1: Int = nums1.size
    val n2: Int = nums2.size

    println(" size of n1 =$n1 || size of n2 $n2")
    //if n1 is bigger swap the arrays:
    if (n1 > n2) return findMedianSortedArraysOptimal(nums2, nums1)

    val n = n1 + n2 //total length
    val left = (n1 + n2 + 1) / 2 //length of left half
    println("total length = $n  || left => $left")
    //apply binary search:
    var low = 0
    var high = n1

    while (low <= high) {
        val mid1 = (low + high) / 2
        val mid2 = left - mid1
        println(" low $low || high $high")
        println("mid1 =$mid1 || mid 2-> $mid2")
        //calculate l1, l2, r1 and r2;
        val l1 = if ((mid1 > 0)) nums1[mid1 - 1] else Int.MIN_VALUE
        val l2 = if ((mid2 > 0)) nums2[mid2 - 1] else Int.MIN_VALUE
        val r1 = if ((mid1 < n1)) nums1[mid1] else Int.MAX_VALUE
        val r2 = if ((mid2 < n2)) nums2[mid2] else Int.MAX_VALUE
        println("l1 $l1 ")
        println("l2 $l2 ")
        println("r1 $r1 ")
        println("r2 $r2 ")

        if (l1 <= r2 && l2 <= r1) {
            return if (n % 2 == 1) max(l1.toDouble(), l2.toDouble())
            else (max(l1.toDouble(), l2.toDouble()) + min(r1.toDouble(), r2.toDouble())) / 2.0
        } else if (l1 > r2) high = mid1 - 1
        else low = mid1 + 1
    }
    return 0.0 //dummy statement

}

/**
 * Time complexity  0(n1+n2)
 * space complexity 0(1) as we are not using extra space
 */
fun findMedianSortedArraysBetter(nums1: IntArray, nums2: IntArray): Double {
    val n1 = nums1.size
    val n2 = nums2.size
    val totalLength = n1 + n2

    var idxN1=totalLength/2
    var idxN2=idxN1-1 // if totalLength is odd, idxN1=idxN2

    var count =0
    var i=0
    var j=0

    var element1=-1
    var element2=-1
    while (i<n1&&j<n2){

        //if element at nums1 < nums 2
        if (nums1[i]<nums2[j]){
            if (count==idxN1)element1 =nums1[i]
            if (count==idxN2)element2 =nums1[i]
            count++
            i++
        }else {
            if (count==idxN1)element1 =nums2[j]
            if (count==idxN2)element2 =nums2[j]
            count++
            j++
        }
    }

    //copy out left elements
    while (i<n1){
        if (count==idxN1)element1 =nums1[i]
        if (count==idxN2)element2 =nums1[i]
        count++
        i++
    }

    while (j<n2){
        if (count==idxN1)element1 =nums2[j]
        if (count==idxN2)element2 =nums2[j]
        count++
        j++
    }


    return if (totalLength%2==0){
        (element1+element2)/2.0
    }else{
        element1.toDouble()
    }
}

/**
 * Time complexity  0(n1+n2)
 * space complexity 0(n1+n2) as we are not using extra space
 */
fun findMedianSortedArraysBruteForce(nums1: IntArray, nums2: IntArray): Double {
    val mergedArray = nums1 + nums2
    mergedArray.sort()
    val n = mergedArray.size
    return if (n % 2 == 0) {
        (mergedArray[n / 2] + mergedArray[n / 2 - 1]) / 2.0
    } else {
        mergedArray[n / 2].toDouble()
    }

}


fun main() {
    val input = intArrayOf(1, 4, 7, 10, 12)
    val input2 = intArrayOf(2, 3, 6, 15)
    println(findMedianSortedArraysBruteForce(input, input2))
    println(findMedianSortedArraysBetter(input, input2))
    println(findMedianSortedArraysOptimal(input, input2))
}