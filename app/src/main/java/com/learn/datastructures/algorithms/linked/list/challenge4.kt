package com.learn.datastructures.algorithms.linked.list

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {

    if(this.isEmpty()) return otherList
    if(otherList.isEmpty()) return this

    if(this.size <=  otherList.size) {
        merge(this, otherList)
    }else{
        merge(otherList, this)
    }

    return otherList

    }

    fun <T : Comparable<T>> LinkedList<T>.merge(small: LinkedList<T>, big: LinkedList<T>) {

        var result = LinkedList<T>()

        var temp = small.head

        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }

//
////    if (this.isEmpty()) return otherList
////    if (otherList.isEmpty()) return this
//
//    val result = LinkedList<T>()
//
//    var left = nodeAt(0)
//    var right = otherList.nodeAt(0)
//
//    while (left != null && right != null) {
//        if (left.value < right.value) {
//            left = append(result, left)
//        } else {
//            right = append(result, right)
//        }
//    }
//
//    while (left != null) {
//        left = append(result, left)
//    }
//
//    while (right != null) {
//        right = append(result, right)
//    }

//    return LinkedList<T>()
//}

private fun <T : Comparable<T>> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}