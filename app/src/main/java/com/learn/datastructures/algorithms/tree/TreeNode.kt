package com.learn.datastructures.algorithms.tree

//typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun depthFirst(nodeTree: TreeNode<T>) {

        println(nodeTree.value)

        nodeTree.children.forEach{ node ->
            node.depthFirst(node)
        }

    }

//    fun forEachDepthFirst(visit: Visitor<T>) {
//        visit(this)
//        children.forEach{
//            it.forEachDepthFirst(visit)
//        }
//    }

}