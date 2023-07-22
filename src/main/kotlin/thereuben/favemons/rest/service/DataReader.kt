import data.FavPkmn
import java.io.File

class DataReader {

    private val filepath = "src/main/resources/faveMons.csv"

    fun readCsv(): MutableList<FavPkmn> {
        val dataList = mutableListOf<FavPkmn>()
        var reader = File(filepath).readLines()
        reader = reader.subList(1, reader.size)
        for (line in reader) {
            val entry = line.split(",")
            dataList.add(FavPkmn(entry[0], entry[1], entry[2], entry[3].toInt(), entry[4], entry[5]))
        }

        return dataList
    }

}