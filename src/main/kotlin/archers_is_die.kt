fun main() {
    print("Enter the number of archers: ")
    val archersList: MutableList<Int> = mutableListOf()
    for (i in 1..readln().toInt()) {
        if (i % 2 == 0)
            archersList.add(0)                          // 0 stands for dead archer
        else
            archersList.add(i)
    }

    while (archersList.size != 1) {                                     // Check if there are more than one archer in our list
        if (archersList[archersList.size - 1] == 0) {
            archersList.removeAll { it == 0 }
            for (i in 0 until archersList.size) {
                if (i < archersList.size - 1) {
                    if (i % 2 == 0) {
                        if (archersList.size - 1 != i) archersList[i + 1] = 0
                    }
                }
            }
        }
        else {
            archersList.removeAll { it == 0 }
            for (i in 0 until archersList.size) {
                if (i % 2 != 0) {
                    archersList[i - 1] = 0
                }
            }
            if (archersList.size > 1)
                if (archersList[archersList.size - 2] != 0)
                    archersList[archersList.size - 1] = 0
        }
    }

    print("Survivor Archer is ${archersList.joinToString()}")
}