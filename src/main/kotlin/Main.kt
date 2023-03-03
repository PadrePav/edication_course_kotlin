import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    coding(args)

}
fun encoding (str: String, num: Int):String {
    val encodlist = mutableListOf<Char>()

    for (i in str) {
        encodlist.add((i.code + num).toChar())
    }

    return encodlist.joinToString("")
}
fun decoding (str: String, num: Int):String {
    val encodlist = mutableListOf<Char>()

    for (i in str) {
        encodlist.add((i.code - num).toChar())
    }

    return encodlist.joinToString("")
}
fun coding (arg: Array<String>) {
    val mode = modeFind(arg)
    val key = keyFind(arg)
    val str = strFind(arg)
    val alg = algFind(arg)
    if (str == "" && inFind(arg)) {
        if (!isWriteInOut(arg)) println("Error")
    } else {
        if (alg == "unicode") {
            println(
                when (mode) {
                    "enc" -> encoding(str, key)
                    "dec" -> decoding(str, key)
                    else -> "Unknown action!"
                }
            )
        } else {
            println(
                when (mode) {
                    "enc" -> shiftEnc(str, key)
                    "dec" -> shiftDec(str, key)
                    else -> "Unknown action!"
                }
            )
        }
    }
}
fun algFind (arg: Array<String>): String {
    val res = "shift"
    for ((i, v) in arg.withIndex()) {
        if (v == "-alg") return arg[i + 1]
    }
    return res
}
fun modeFind (arg: Array<String>): String {
    var res = "enc"
    for ( v in arg) {
        if (v == "enc" || v == "dec") res = v
    }
    return res
}
fun keyFind (arg: Array<String>): Int {
    var res = 0
    for ((i, v) in arg.withIndex()) {
        if (v == "-key") if (arg[i + 1].toIntOrNull() != null) res = arg[i + 1].toInt()
    }
    return res
}
fun strFind (arg: Array<String>):String {
    val res = ""
    for ((i, v) in arg.withIndex()) {
        if (v == "-data") return arg[i + 1]
    }
    return res
}
fun inFind(arg: Array<String>):Boolean {
    var res = false
    for (v in arg) {
        if (v == "-in") res = true
    }
    return res
}
fun outText(arg: Array<String>):String {
    var res = ""
    for ((i, v) in arg.withIndex()) {
        if (v == "-out") res = arg[i + 1]
    }
    return res
}
fun readTextFromFile(arg: Array<String>):String {
    val path = System.getProperty("user.dir")
    val separator = File.separator
    var res = ""
    for ((i, v) in arg.withIndex()) {
        if (v == "-in") res = arg[i + 1]
    }
    try {
        if (res != "") res = File("$path$separator$res").readText()
    } catch (e: FileNotFoundException) {
        res = "Error"
    }
    return res
}
fun isWriteInOut (arg: Array<String>):Boolean {
    val path = System.getProperty("user.dir")
    val separator = File.separator
    val mode = modeFind(arg)
    val key = keyFind(arg)
    val text = readTextFromFile(arg)
    val writeFile = outText(arg)
    val alg = algFind(arg)
    return if ((inFind(arg) && text != "Error") && (writeFile != "")) {
        if (alg == "unicode") {
            when (mode) {
                "enc" -> File("$path$separator$writeFile").writeText(encoding(text, key))
                "dec" -> File("$path$separator$writeFile").writeText(decoding(text, key))
            }
        } else {
            when (mode) {
                "enc" -> File("$path$separator$writeFile").writeText(shiftEnc(text, key))
                "dec" -> File("$path$separator$writeFile").writeText(shiftDec(text, key))
            }
        }
        true
    } else if (inFind(arg) && text != "Error") {
        if (alg == "unicode") {
            when (mode) {
                "enc" -> println(encoding(text, key))
                "dec" -> println(decoding(text, key))
            }
        } else {
            when (mode) {
                "enc" -> println(shiftEnc(text, key))
                "dec" -> println(shiftDec(text, key))
            }
        }
        true
    } else {
        false
    }
}
fun shiftEnc(str: String, key: Int):String {
    val alphabetLower = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val alphabetUpper = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val cipher = mutableListOf<Char>()
    for (value in str) {
        if (alphabetLower.contains(value)) {
            if (alphabetLower.indexOf(value) + key <= alphabetLower.size-1) {
                cipher.add(alphabetLower[alphabetLower.indexOf(value) + key])
            } else {
                cipher.add(alphabetLower[(alphabetLower.indexOf(value) + key) - 26])
            }
        } else if (alphabetUpper.contains(value)) {
            if (alphabetUpper.indexOf(value) + key <= alphabetUpper.size-1) {
                cipher.add(alphabetUpper[alphabetUpper.indexOf(value) + key])
            } else {
                cipher.add(alphabetUpper[(alphabetUpper.indexOf(value) + key) - 26])
            }
        } else {
            cipher.add(value)
        }
    }
    return cipher.joinToString("")
}
fun shiftDec(str: String, key: Int):String {
    val alphabetLower = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val alphabetUpper = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val cipher = mutableListOf<Char>()
    for (value in str) {
        if (alphabetLower.contains(value)) {
            if (alphabetLower.indexOf(value) - key <= 0) {
                cipher.add(alphabetLower[alphabetLower.indexOf(value) - key])
            } else {
                cipher.add(alphabetLower[(alphabetLower.indexOf(value) - key) + 26])
            }
        } else if (alphabetUpper.contains(value)) {
            if (alphabetUpper.indexOf(value) - key <= 0) {
                cipher.add(alphabetUpper[alphabetUpper.indexOf(value) - key])
            } else {
                cipher.add(alphabetUpper[(alphabetUpper.indexOf(value) - key) + 26])
            }
        } else {
            cipher.add(value)
        }
    }
    return cipher.joinToString("")
}
