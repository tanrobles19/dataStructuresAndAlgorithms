package com.learn.datastructures.algorithms.linked.list

data class Node<T: Any>(var value: T, var next: Node<T>? = null){
    override fun toString(): String {
        return if (next != null) {
            "$value = ${next.toString()}"
        }else{
            "$value"
        }
    }

    fun printInReverse() {
        this.next?.printInReverse()

        if(this.next != null)
            print(" <- ")

        print(this.value.toString())

    }// end

    fun reverse(): Node<T>{

        val tempo = this.next?.reverse()

        if(this.next != null) {
            tempo?.next = this
        }

        return this

    }

    fun reverseTest() {
        this.next?.reverseTest()

//        if(this.next != null)
            print(" <- ")

        print(this.value.toString())

    }



}
