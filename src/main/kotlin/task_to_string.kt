val wList = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
fun main () {
    println("text any number ")
    val number = readln().toLong()
    println("assign the number system ")
    val numSystem = readln().toLong()
    val listSystem: MutableList<Any> = mutableListOf()
    var division = number
    while (division != 0L) {
       val remainder = division % numSystem

        if (remainder in 10..35)
            listSystem.add(wList[remainder.toInt() - 10])
        else listSystem.add(remainder.toInt())

        division /= numSystem
    }
    println(listSystem.reversed().joinToString(""))
}