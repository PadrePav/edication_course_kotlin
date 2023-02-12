import java.lang.reflect.Array
import java.util.Currency

/*
var listValueSame: MutableList<Int> = mutableListOf()
fun main() {
    val list = mutableListOf ( 5, 6, 4, 56, 56, 58, 5, 0, 58, 45, 55  )
    var maxValue = 0
    var indexValue = 0
    for ((ind, value) in list.withIndex()) {
        if (maxValue < value) {
            indexValue = ind
            maxValue = value
            listValueSame = mutableListOf(ind)
        }
        else if (maxValue == value) {
            listValueSame.add(ind)

        }

    }
    if (listValueSame.size == 1)
        listValueSame = mutableListOf()

    println(maxValue)
    println(indexValue)
    println(listValueSame.joinToString())
}*/

//    val n = readln().toInt()
//    var res = n
//    print("$res ")
//    val list: MutableList<Int> = mutableListOf()
//    while (res > 1) {
//        if (res % 2 == 0) res /= 2
//        else res = res * 3 + 1
//        list.add(res)
//        print("$res ")
//    }
//    println("\n${list.max()}")

fun main() {
    val n = readln()
    print(n.first())
}
