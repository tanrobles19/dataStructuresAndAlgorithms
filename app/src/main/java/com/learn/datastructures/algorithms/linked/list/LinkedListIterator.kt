package com.learn.datastructures.algorithms.linked.list

class LinkedListIterator<T : Any>(private val list: LinkedList<T>) :  MutableIterator<T>{

    private var index = 0
    private var lastNode: Node<T>? = null

    override fun next(): T {

        if( index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if(index == 0) {
            list.nodeAt(0)
        }else{
            lastNode?.next
        }

        index++

        return lastNode!!.value

    }

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun remove() {
        if(index == 1) {
            list.pop()
        }else{
            val preNode = list.nodeAt( index -2 )?: return
            list.removeLast()
            lastNode = preNode
        }
        index--
    }

}