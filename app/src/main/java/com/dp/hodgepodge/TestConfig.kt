package com.dp.hodgepodge

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/20
 *  desc   : kotlin 基本语法练习
 */
//如果想写工具类的功能，直接创建文件，写 top-level「顶层」函数。
//如果需要继承别的类或者实现接口，就用 object 或 companion object。
//顶层声明 :这样写的属性和函数，不属于任何 class，而是直接属于 package，它和静态变量、静态函数一样是全局的，但用起来更方便：你在其它地方用的时候，就连类名都不用写：
var topName = 21
fun topFun() {
    println("我是顶层声明的方法")
}


class TestConfig {
    init {
        // 初始化代码块，先于下面的构造器执行
        print("init:初始化代码块，先于下面的构造器执行")
    }

    //关键字 构造方法 啃死抓课滔

    constructor() {
        print("constructor:")
    }

    //    Kotlin 中的 val 和 Java 中的 final 类似，表示只读变量，不能修改。这里分别从成员变量、参数和局部变量来和 Java 做对比
    val final1 = 1

    //    不过 val 和 final 还是有一点区别的，虽然 val 修饰的变量不能二次赋值，但可以通过自定义变量的 getter 函数，让变量每次被访问时，返回动态获取的值：
    val size: Int
        get() {
            return 12
        }

    //用 object 修饰的对象中的变量和函数都是静态的，但有时候，我们只想让类中的一部分函数和变量是静态的该怎么做呢
//   伴生对象
    companion object {
        val anotherString = "Another String"
    }

    //    但这里有一个小限制：一个类中最多只可以有一个伴生对象，但可以有多个嵌套对象。就像皇帝后宫佳丽三千，但皇后只有一个。
    object Test {
        val ERROR = 21
    }

    //    Java 中的 Object 在 Kotlin 中变成了 Any，和 Object 作用一样：作为所有类的基类。
    //常量的声明
//    Kotlin 中只有基本类型和 String 类型可以声明成常量。
    object Const {
        const val CONST_NUMBER = 1
    }


    //数组 不支持 协变
    val strs: Array<String> = arrayOf("1", "2", "3")

    //    支持 covariant（协变）。也就是说，可以把子类的 List 赋值给父类的 List 变量：
    val strList = listOf("a", "b", "c")

    //把不变转为可变
    var strMutableList = strList.toMutableList()

    //直接声明可以变的数组
    val strList1 = mutableListOf<String>("a", "b", "c")


    //set Set 同样具有 covariant（协变）特
    val strSet = setOf("a", "b", "c")

    val map = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 3)

//    listOf() 创建不可变的 List，mutableListOf() 创建可变的 List。
//    setOf() 创建不可变的 Set，mutableSetOf() 创建可变的 Set。
//    mapOf() 创建不可变的 Map，mutableMapOf() 创建可变的 Map。
//    toMutable*() 返回的是一个新建的集合，原有的集合还是不可变的，所以只能对函数返回的集合修改。

//    Sequence
//    除了集合 Kotlin 还引入了一个新的容器类型 Sequence，它和 Iterable 一样用来遍历一组数据并可以对每个元素进行特定的处理，先来看看如何创建一个 Sequence。、

    var sequence = sequenceOf("a", "b", "c")

    //    🏝️
    val list = listOf("a", "b", "c")

    //转换
    var sequencea = list.asSequence()

//    public ：公开，可见性最大，哪里都可以引用。
//private：私有，可见性最小，根据声明位置不同可分为类中可见和文件中可见。
//protected：保护，相当于 private + 子类可见。
//internal：内部，仅对 module 内可见。


}
//主构造函数
//一个统一的参数的入口，用来初始化
class User constructor(name:String){
    //初始地1
    var name=name
    //初始地2
    init {

    }

}

// 渐变写法
fun sayHi(name: String = "world", age: Int, isStudent: Boolean = true, isFat: Boolean = true, isTall: Boolean = true) {
}


