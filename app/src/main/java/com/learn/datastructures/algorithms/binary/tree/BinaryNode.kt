package com.learn.datastructures.algorithms.binary.tree

//typealias Visitor<T> = (T) -> Unit

class BinaryNode<T: Comparable<T>>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    /*
        1. If the current node has a left child, recursively visit this child first.
        2. Then visit the node itself.
        3. If the current node has a right child, recursively visit this child.
     */
    fun InOrderTraversal(node: BinaryNode<T>){
        node.leftChild?.InOrderTraversal(node.leftChild!!)
        print(node.value)
        node.rightChild?.InOrderTraversal(node.rightChild!!)
    }

    /* The height of the Binary tree is determined by the
     *  distance between the root and the furthest leaf
     */
    fun heightOfTheTree() {

    }

    fun isBST(node: BinaryNode<T>?): Boolean {

        node?: return true

        node.leftChild?.let{
            if(node.value <= it.value) return false
        }

        node.rightChild?.let{
            if(node.value > it.value) return false
        }

        return isBST(node.rightChild) && isBST(node.leftChild)

    }// end fun isBST()

    fun validateEquality(nodeA: BinaryNode<T>?, nodeB: BinaryNode<T>?): Boolean {

        if(nodeA == null && nodeB == null) return true

        if (!compareNode(nodeA?.leftChild, nodeB?.leftChild)) {
            return false
        }

        if (!compareNode(nodeA?.rightChild, nodeB?.rightChild)) {
            return false
        }

        return validateEquality(nodeA?.leftChild, nodeB?.leftChild) &&
                validateEquality(nodeA?.rightChild, nodeB?.rightChild)

    }// end fun validateEquality()

    private fun compareNode(nodeA: BinaryNode<T>?, nodeB: BinaryNode<T>?): Boolean {

        if(nodeA == null && nodeB == null) return true

        if(nodeA != null && nodeB != null) return true

        return false

    }// end fun compareNode()

}

