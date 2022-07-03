package com.learn.datastructures.algorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learn.datastructures.algorithms.databinding.FragmentFirstBinding
import com.learn.datastructures.algorithms.linked.list.LinkedList
import com.learn.datastructures.algorithms.linked.list.findElementToMerge
import com.learn.datastructures.algorithms.linked.list.merge
import com.learn.datastructures.algorithms.linked.list.mergeSorted
import com.learn.datastructures.algorithms.sort.InsertionSort
import com.learn.datastructures.algorithms.stack.StackImpl

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

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

            checkParenthesesValidation("(h((e))l(lo(wor(ld)()aA))")
//            checkParenthesesValidation("{[]}()")

        }

    }// end fun onViewCreated

    private fun checkParenthesesValidation(dataSource: String) {

        val charDataSource = dataSource.toCharArray()

        val stack = StackImpl<Char>()

        val bracketList = listOf('(', ')', '{', '}', '[', ']')

        charDataSource.forEachIndexed{index, char ->

            if(bracketList.contains(char)) {

                if(stack.isEmpty || stack.peek() == char){
                    println("Index $index")
                    stack.push(char)
                }else{
                    stack.pop()
                }

            }// end if

        }// end for

        if(stack.isEmpty) {
            println("Balanced Parenthesis")
        }else{
            println("unBalanced Parenthesis")
        }

    }// end fun checkParenthesesValidation()

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