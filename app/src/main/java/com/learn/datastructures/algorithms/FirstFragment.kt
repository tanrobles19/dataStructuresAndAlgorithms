package com.learn.datastructures.algorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learn.datastructures.algorithms.databinding.FragmentFirstBinding
import com.learn.datastructures.algorithms.linked.list.LinkedList
import com.learn.datastructures.algorithms.queue.ArrayListQueue
import com.learn.datastructures.algorithms.sort.InsertionSort
import com.learn.datastructures.algorithms.stack.Bracket
import com.learn.datastructures.algorithms.stack.StackImpl
import com.learn.datastructures.algorithms.tree.TreeNode

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val list = arrayListOf<String>()

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {

            val insertionSort = InsertionSort()

            val list: IntArray = intArrayOf( 10, 5, 2, 4, 12, 6, 100, 3, 8, 20, 25, 1 )

//            insertionSort.printList(5, list)
            insertionSort.insertionSort(11, list)

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonLinkedList.setOnClickListener {

//            val listA = LinkedList<Int>().apply {
//                add(3)
//            }
//
//            val listB = LinkedList<Int>().apply {
//                add(2)
//                add(4)
//                add(6)
//                add(8)
//                add(10)
//                add(12)
//            }
//
//            val list = listOf("A","B","C", "D")
//            val stack = StackImpl.create(list)
//            print(stack)
//            println("Popped: ${stack.pop()}")

//            val stack = StackImpl<Int>().apply {
//                push(1)
//                push(2)
//                push(3)
//                push(4)
//                push(5)
//            }
//
//            print(stack)
//
//            stack.pop()?.let {
//                println("Popped out $it")
//            }

//            print(stack)


//            val list = listOf(1,2,3,4,5,6)
//            val stack = StackImpl.create(list)

//            reverseLinkedList()

//            checkParenthesesValidation("(h((e))l(lo(wor(ld)()aA))")
//            checkWrongFirstBracket("(h((e))l(lo(wor(ld)()aA))").let {
//                if(it == null) {
//                    println("Balanced Parenthesis")
//                }else{
//                    println("unBalanced Parenthesis: ${it.position}")
//                }
//            }// end fun checkParenthesesValidation

//            reverseDataInQueue()

            val ROOT = TreeNode("Beverages")

            val hot = TreeNode("hot")
            val cold = TreeNode("cold")

            val tea = TreeNode("tea")
            val coffee = TreeNode("coffee")
            val chocolate = TreeNode("cocoa")

            val blackTea = TreeNode("black")
            val greenTea = TreeNode("green")
            val chaiTea = TreeNode("chai")

            val soda = TreeNode("soda")
            val milk = TreeNode("milk")

            val gingerAle = TreeNode("ginger ale")
            val bitterLemon = TreeNode("bitter lemon")

            val tan = TreeNode("TAN")

            ROOT.add(hot)
            ROOT.add(cold)

            hot.add(tea)
            hot.add(coffee)
            hot.add(chocolate)

            cold.add(soda)
            cold.add(milk)

            tea.add(blackTea)
            tea.add(greenTea)
            tea.add(chaiTea)

            soda.add(gingerAle)
            soda.add(bitterLemon)

            chaiTea.add(tan)

//            val ROOT = TreeNode("1")
//
//            val two = TreeNode("2")
//            val three = TreeNode("3")
//            val a = TreeNode("a")
//            val b = TreeNode("b")
//            val c = TreeNode("c")
//            val tan = TreeNode("tan")
//
//            ROOT.add(two)
//            ROOT.add(three)
//
//            two.add(a)
//            two.add(b)
//
//            three.add(c)
//
//            c.add(tan)

//            ROOT.depthFirst(ROOT)

            ROOT.levelOrderTraversal(ROOT)

        }

    }// end fun onViewCreated

    private fun reverseDataInQueue() {

        val queue = ArrayListQueue<String>().apply {
            enqueue("A")
            enqueue("S")
            enqueue("A")
            enqueue("C")
        }

        println(queue)

        val stack = StackImpl<String>()

        while (!queue.isEmpty) {
            stack.push(queue.dequeue().toString())
        }

        while (!stack.isEmpty) {
            queue.enqueue(stack.pop().toString())
        }

        println(queue)

    }// end fun reverseDataInQueue()

    private fun checkParenthesesValidation(dataSource: String): Boolean {

        val charDataSource = dataSource.toCharArray()

        val stack = StackImpl<Char>()

        charDataSource.forEachIndexed{index, character ->

            when(character) {
                '(' -> stack.push(character)
                ')' -> if (stack.isEmpty) return false else stack.pop()
            }

        }// end for

        return stack.isEmpty

    }// end fun checkParenthesesValidation()

    private fun checkWrongFirstBracket(dataSource: String): Bracket? {

        val charDataSource = dataSource.toCharArray()

        val stack = StackImpl<Bracket>()

        charDataSource.forEachIndexed{index, character ->

            //TODO more complex scenary, you need to keep track of the first wrong bracket
            // use a Bracket data class to store the index reference.

            val bracket = Bracket(character, index)

            when(character) {
                '(' -> stack.push(bracket)
                ')' -> if (stack.isEmpty) return bracket else stack.pop()
            }

        }// end for

        if(stack.isEmpty) {
            return null
        }else{
            return stack.peek()
        }

    }// end fun checkWrongFirstBracket()

    private fun reverseLinkedList() {

        val linkedList = LinkedList<Int>().apply {
            add(1)
            add(2)
            add(3)
            add(4)
            add(5)
        }

        val stack = StackImpl<Int>()

        var temp = linkedList.head

        while (temp != null) {
            stack.push(temp.value)
            temp = temp.next
        }

        while (!stack.isEmpty){
            val p = stack.pop()
            println(p)
        }

    }// end fun reverseLinckedList()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}