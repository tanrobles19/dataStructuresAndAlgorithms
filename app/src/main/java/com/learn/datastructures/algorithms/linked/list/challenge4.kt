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

            big.head?.findElementRecursive(temp.value)

        temp = temp.next
    }
    return big
}

fun <T : Comparable<T>> Node<T>.findElementRecursive(element: T): Boolean{

    val jobDone = this.next?.findElementRecursive(element)

    if(jobDone == true){
        return true
    }

    return if(this.value <= element) {
        val next = this.next
        this.next = Node(element, next)
        true
    }else{
        false
    }
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