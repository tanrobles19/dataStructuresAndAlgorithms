package com.learn.datastructures.algorithms.uber

class FizzBuzzChallenge {

    fun uberFizzBuzzChallenge(n: Int) {

        (1..n).forEach { number ->
            when {
                mod(number, 3) && mod(number, 5) -> println("FizzBuzz")
                mod(number, 3) && !mod(number, 5) -> println("Fizz")
                !mod(number, 3) && mod(number, 5) -> println("Buzz")
                !mod(number, 3) && !mod(number, 5) -> println(number)
            }
        }

    }// end fun uberFizzBuzzChallenge()

    // Util function
    private fun mod(number: Int, divider: Int) = number.mod(divider) == 0

}