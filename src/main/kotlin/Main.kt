fun main() {
    /*val wordArray1 = arrayOf("засунь", "выкень", "включи", "съешь")
    val wordArray2 = arrayOf("свой", "мой", "её", "наш")
    val wordArray3 = arrayOf("телефон", "компьютер", "квадрацыкл", "имплант")
    val wordArray4 = arrayOf("под", "в", "через", "на")
    val wordArray5 = arrayOf("нос", "машину", "бабушку", "ногу")
    val wordSize1 = wordArray1.size
    val wordSize2 = wordArray2.size
    val wordSize3 = wordArray3.size
    val wordSize4 = wordArray4.size
    val wordSize5 = wordArray5.size
    val wordPrint1 = (Math.random() * wordSize1).toInt()
    val wordPrint2 = (Math.random() * wordSize2).toInt()
    val wordPrint3 = (Math.random() * wordSize3).toInt()
    val wordPrint4 = (Math.random() * wordSize4).toInt()
    val wordPrint5 = (Math.random() * wordSize5).toInt()
    println("${wordArray1.get(wordPrint1)} ${wordArray2.get(wordPrint2)} ${wordArray3.get(wordPrint3)} ${wordArray4.get(wordPrint4)} ${wordArray5.get(wordPrint5)}")
*/
    val dayMoodArray = arrayOf("замечательным", "прекрасным", "тухлым", "божественным", "неможечко с кислинкой", "полен разочарований", "непредзказуемым", "романтичным, но не слишком", "подавленным", "догим", "лучше чем у твоего соседа", "историческим", "обычным", "кошмарным(извини)", "... такой же как и вчерашний", "энергичным как рево", "полисемантический")
    val sizeArray = dayMoodArray.size
    val randomIndex = (Math.random() * sizeArray).toInt()
    println("Твой день сегодня будет ${dayMoodArray.get(randomIndex)}")
}

