package com.dp.hodgepodge

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val list= listOf(21,40,11,33,78)
//        list.filter { i ->
//            i%3== 0}
//            .forEach{
//                    i ->println("${i}可以被3整除 ")
//            }

//var intArray= arrayOf(1,2,3,4)
//    intArray.filter {
//        //条件过滤
//       i -> i==2
//    }.forEach {
//        print("$it")
//    }
//
//    }
//        val range = 0..1000
////               👇 步长为 2，输出：0, 2, 4, 6, 8, 10,....1000,
//        for (i in range step 2) {
//            print("$i, ")
//        }
//


        val sequence = sequenceOf(1, 2, 3, 4)
        val result: Sequence<Int> = sequence
            .map { i ->
                println("Map $i")
                i * 2
            }
            .filter { i ->
                println("Filter $i")
                i % 3 == 0
            }
        println(result.first()) // 👈 只取集合的第一个元素
    }
}