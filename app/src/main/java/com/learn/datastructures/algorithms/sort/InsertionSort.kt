package com.learn.datastructures.algorithms.sort

class InsertionSort {

    fun printList(n: Int, list: IntArray?) {

        var text = ""

        for(i in 0..n) {
            text += ", ${list?.get(i)}"
        }

        println("value = $text")

    }// end fun printList()

    fun insertionSort(n: Int, list: IntArray) {

        var key: Int
        var j: Int

        for (i in 1..n) {
            key = list.get(i)
            j = i - 1
            while (j >= 0 && list.get(index = j) < key){
                list.set(index = j + 1, list.get(index = j) )
                j -= 1
            }
            list.set(index = j + 1, key )
        }// end for

        printList(11, list)

    }// end insertionSort

}