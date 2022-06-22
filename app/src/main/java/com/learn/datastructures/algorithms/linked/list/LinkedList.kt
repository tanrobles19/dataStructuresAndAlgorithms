package com.learn.datastructures.algorithms.linked.list

class LinkedList<T: Any> : Collection<T>, MutableIterable<T>, MutableCollection<T>{

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty List" else head.toString()
    }

    override fun iterator() : MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun contains(element: T): Boolean {
        for(item in this) {
            if (item ==  element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for ( search in elements) {
            if(! contains(search)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {

        append(element)
        return true

//        val node = Node(element, null)
//        if(isEmpty()) {
//            head = node
//        }else{
//            tail?.next = node
//        }
//        tail = node
//        size++
//        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            add(item)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {

        val iterator = iterator()

        while (iterator.hasNext()) {
            val item = iterator.next()
            if(element == item) {
                iterator.remove()
                return true
            }
        }

        return false

//        if(isEmpty())
//            return false
//
//        if(head?.value == element) {
//            head = head?.next
//            size--
//            if(head == null) {
//                clear()
//            }
//            return true
//        }else{
//            findByElementValue(element)?.let {
//                it.next = it.next?.next
//                size--
//                return true
//            }
//        }
//        return false
    }// end remove fun

    fun findByElementValue(element: T) : Node<T>? {

        if (!isEmpty() && head?.value == element)
            return head

        var nodeTemp = head

        while ( nodeTemp?.next != null) {
            if(element ==  nodeTemp.next?.value) {
                return nodeTemp
            }
            nodeTemp = nodeTemp.next
        }
        return null
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        for(element in elements) {
            remove(element)
        }
        return false
    }

    override fun retainAll(elements: Collection<T>): Boolean {

        var result = false
        val iterator = iterator()

        while (iterator.hasNext()) {
            val node = iterator.next()
            if(!elements.contains(node)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }// end fun retainAll()

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

    /*
    * Time Complexity: Constant Time O(1)
    *
    * */
    fun pop(): T? {
        if(isEmpty()) {
            return null
        }
        size--
        val value = head?.value
        head = head?.next

        return value
    }// end fun pop()

    /*
    * Time Complexity: Linear Time O(i)
    *
    * */
    fun removeLast() :T? {

        if (isEmpty()) {
            return null
        }

        val value = tail?.value

        if(size == 1) {
            head = null
            tail = null
            size = 0
            return value
        }

        val newTail = nodeAt(size -2)

        newTail?.next = null
        tail = newTail

        size--

        return value

    }// end fun removeLast()


    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

    fun reverseList(): LinkedList<T> {

        val iterator = iterator()

        val tempList = LinkedList<T>()

        while (iterator.hasNext()) {
            val value = pop()
            value?.let {
                tempList.push(it)
            }

        }

        return tempList

    }

}