package com.learn.datastructures.algorithms.tree

import com.learn.datastructures.algorithms.queue.ArrayListQueue
import com.learn.datastructures.algorithms.queue.Queue

//typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun depthFirst(nodeTree: TreeNode<T>) {

        println(nodeTree.value)

        nodeTree.children.forEach{ node ->
            node.depthFirst(node)
        }

    }

    fun levelOrderTraversal(nodeTree: TreeNode<T>) {

        println(nodeTree.value)

        val queue = ArrayListQueue<TreeNode<T>>()
        nodeTree.children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()

        while (node != null) {
            println(node.value)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }

    }// end fun levelOrderTraversal

//    fun forEachDepthFirst(visit: Visitor<T>) {
//        visit(this)
//        children.forEach{
//            it.forEachDepthFirst(visit)
//        }
//    }

}