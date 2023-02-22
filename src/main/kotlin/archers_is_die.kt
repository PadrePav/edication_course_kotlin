fun main() {
    print("Enter the number of archers: ")
    val countArchers = readln().toInt()
    val archersList: MutableList<Int> = mutableListOf()
    for (i in 1..countArchers) {
        archersList.add(i)
    }
    val secondArchList: MutableList<Int> = mutableListOf()
    var check = 0
    while (archersList.size + secondArchList.size != 1) {
        if (archersList.size != 0) {
            for ((i, v) in archersList.withIndex()) {
                if (check != 1) {
                    if (i % 2 == 0) {
                        secondArchList.add(v)
                        if (i < archersList.size - 1)
                            archersList[i + 1] = 0
                    }
                }
                else {
                    if (i % 2 != 0) {
                        secondArchList.add(v)
                        archersList[i - 1] = 0
                    }
                }
            }
            if (archersList[archersList.size - 1] == 0) {
                check = 0
            } else {
                check = 1
            }
            archersList.clear()
        }
        else {
            for ((i, v) in secondArchList.withIndex()) {
                if (check != 1) {
                    if (i % 2 == 0) {
                        archersList.add(v)
                        if (i < secondArchList.size - 1)
                            secondArchList[i + 1] = 0
                    }
                }
                else {
                    if (i % 2 != 0) {
                        archersList.add(v)
                        secondArchList[i - 1] = 0
                    }
                }
            }
            if (secondArchList[secondArchList.size - 1] == 0) {
                check = 0
            } else {
                check = 1
            }
            secondArchList.clear()
        }
    }
    print("Survivor Archer is ")
    if (archersList.size == 1)
    println(archersList.joinToString())
    else
    println(secondArchList.joinToString())
}