import data.FavPkmn

class DataService {

    private val genSizeMap = mapOf(
        1 to 151,
        2 to 100,
        3 to 135,
        4 to 107,
        5 to 156,
        6 to 72,
        7 to 88,
        8 to 96,
        9 to 105
    )

    private val validTypesPrimary = setOf(
        "Grass",
        "Fire",
        "Water",
        "Normal",
        "Electric",
        "Psychic",
        "Fighting",
        "Rock",
        "Ground",
        "Flying",
        "Bug",
        "Poison",
        "Dark",
        "Ghost",
        "Ice",
        "Steel",
        "Dragon",
        "Fairy"
    )

    fun numChatters(dataList: MutableList<FavPkmn>): Int {

        return dataList
            .groupBy { it.person }
            .count();

    }

    fun numUniqueMons(dataList: MutableList<FavPkmn>): Int {

        return dataList
            .groupBy { it.monName }
            .count()

    }

    fun numUniqueMonsPerGen(dataList: MutableList<FavPkmn>): List<Map.Entry<Int, Int>> {

        return dataList
            .groupBy { it.gen }
            .mapValues { entry -> entry.value.groupBy { it.monName }.size }
            .entries.sortedByDescending { it.value }

    }

    fun numUniqueMonsPerGenPercent(dataList: MutableList<FavPkmn>): List<Map.Entry<Int, Int>> {

        return dataList
            .groupBy { it.gen }
            .mapValues { entry ->
                ( entry.value.groupBy { it.monName }.size.toDouble() / genSizeMap.getOrDefault(entry.key, 100) * 100 ).toInt()
            }
            .entries.sortedByDescending { it.value }

    }

    fun faveGens(dataList: MutableList<FavPkmn>): List<Map.Entry<Int, Int>> {

        return dataList
            .groupBy { it.gen }
            .mapValues { it.value.size }
            .filter { it.value > 1 }
            .entries.sortedByDescending { it.value }

    }

    fun faveGensPercent(dataList: MutableList<FavPkmn>): List<Map.Entry<Int, Int>> {

        return dataList
            .groupBy { it.gen }
            .mapValues {
                ((it.value.size.toDouble() / dataList.size) * 100 ).toInt()
            }
            .filter { it.value > 1 }
            .entries.sortedByDescending { it.value }

    }

    fun faveMons(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.monName }
            .mapValues { it.value.size }
            .filter { it.value > 1 }
            .entries.sortedByDescending { it.value }

    }

    fun favePrimaryTypes(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.primaryType }
            .mapValues { it.value.size }
            .entries.sortedByDescending { it.value }

    }

    fun favePrimaryTypesPercent(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.primaryType }
            .mapValues {
                ((it.value.size.toDouble() / dataList.size) * 100 ).toInt()
            }
            .entries.sortedByDescending { it.value }

    }

    fun faveSecondaryTypes(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.secondaryType }
            .mapValues { it.value.size }
            .entries.sortedByDescending { it.value }

    }

    fun faveSecondaryTypesPercent(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.secondaryType }
            .mapValues {
                ((it.value.size.toDouble() / dataList.size) * 100 ).toInt()
            }
            .entries.sortedByDescending { it.value }

    }

    fun faveTotalTypes(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        val primaryMap = dataList
            .groupBy { it.primaryType }
            .mapValues { it.value.size }.toMutableMap()

        val secondaryMap = dataList
            .groupBy { it.secondaryType }
            .mapValues { it.value.size }

        primaryMap.forEach {
            primaryMap[it.key] = (it.value + (secondaryMap[it.key] ?: 0))
        }

        return primaryMap.entries.sortedByDescending { it.value }


    }

    fun faveTotalTypesPercent(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        val primaryMap = dataList
            .groupBy { it.primaryType }
            .mapValues { it.value.size }.toMutableMap()

        val secondaryMap = dataList
            .groupBy { it.secondaryType }
            .mapValues { it.value.size }

        primaryMap.forEach {
            primaryMap[it.key] = (it.value + (secondaryMap[it.key] ?: 0))
        }

        val percentMap = primaryMap.mapValues {
            ((it.value.toDouble() / dataList.size) * 100 ).toInt()
        }

        return percentMap.entries.sortedByDescending { it.value }


    }

    fun faveCombinedTypes(dataList: MutableList<FavPkmn>): List<Map.Entry<String, Int>> {

        return dataList
            .groupBy { it.primaryType + "-" + it.secondaryType }
            .mapValues { it.value.size }
            .entries.sortedByDescending { it.value }

    }

    fun faveCombinedTypesNum(dataList: MutableList<FavPkmn>): Int {

        return dataList
            .groupBy { it.primaryType + "-" + it.secondaryType }
            .count()

    }

    fun monotypes(dataList: MutableList<FavPkmn>): List<String> {

        val monotypes = dataList
            .filter { it.secondaryType == "None" }
            .groupBy { it.primaryType }
            .map { it.key }
            .sortedDescending()

        return validTypesPrimary.filter { !monotypes.contains(it) }

    }

}