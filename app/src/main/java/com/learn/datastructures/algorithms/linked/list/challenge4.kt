package com.learn.datastructures.algorithms.linked.list

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {

    if(this.isEmpty()) return otherList
    if(otherList.isEmpty()) return this

    return if(this.size <=  otherList.size) {
        merge(this, otherList)
    }else{
        merge(otherList, this)
    }

}

fun <T : Comparable<T>> LinkedList<T>.merge(small: LinkedList<T>, big: LinkedList<T>) : LinkedList<T>{

    var temp = small.head

    while (temp != null) {
        println(temp.value)

        val node = big.findElementToMerge(temp.value)

        val storeNext = node?.next

        node?.next = Node(temp.value, storeNext)

        temp = temp.next
    }
    return big
}

fun <T : Comparable<T>> LinkedList<T>.findElementToMerge(element: T): Node<T>? {

    var temp = this.head

    while(temp != null) {

        val current = temp.next?.value

        if(current != null && current >= element) {
            return temp
        }

        temp = temp.next
    }
    return this.tail
}