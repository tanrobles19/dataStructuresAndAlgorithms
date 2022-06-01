package com.learn.datastructures.algorithms.linked.list

class LinkedList<T: Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty List" else head.toString()
    }

    /*
    * Time Complexity: Constant Time O(1)
    *
    * */
    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    /*
    * Time Complexity: Constant Time O(1)
    *
    * */
    fun append(value: T) {
        if(isEmpty()) {
            push(value = value)
            return
        }

        val newNode = Node(value =  value)
        tail?.next = newNode

        tail = newNode
        size++
    }

    /*
    * Time Complexity: Linear Time O(i)
    *
    * */
    fun nodeAt(index: Int): Node<T>? {

        var currentNode = head
        var currentIndex = 0

        while ( currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(newNode: Node<T>, nodeAt: Node<T>) {
        newNode.next = nodeAt.next
        nodeAt.next = newNode
        size++
    }

    fun removeByIndex(index: Int) {

        if(index == 0) {
            head = head!!.next
            return
        }

        val nodeAt = nodeAt(index - 1)

        val nodeNext = nodeAt?.next?.next

        nodeAt!!.next = nodeNext

        size--
    }

    fun removeByValue(value: Int) {

        var nodeTemp = head
        var index = 0

        while ( nodeTemp != null){
            if (nodeTemp.value == value) {
                removeByIndex(index)
            }
            index++
            nodeTemp = nodeTemp.next
        }

    }// end fun removeByValue()

}