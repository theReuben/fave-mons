import data.FavPkmn

class ValidationService {

    private val numTypes = 19

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

    private val validTypesSecondary = validTypesPrimary + "None"

    private val numGens = 9;

    fun validateTypes(dataList: MutableList<FavPkmn>): Boolean {
        val types = mutableSetOf<String>()
        dataList.forEach {
            if (!validTypesPrimary.contains(it.primaryType)) {
                println(it.primaryType + " is not a valid type (primary)")
                return false
            }
            if (!validTypesSecondary.contains(it.secondaryType)) {
                println(it.secondaryType + " is not a valid type (secondary)")
                return false
            }

            types.add(it.primaryType)
            types.add(it.secondaryType)
        }

        return types.size <= numTypes;
    }

    fun validateGens(dataList: MutableList<FavPkmn>): Boolean {
        val gens = mutableSetOf<Int>()
        dataList.forEach {
            if (it.gen < 1 || it.gen > numGens) {
                println(it.gen.toString() + " is not a valid gen")
                return false;
            }
            gens.add(it.gen)
        }

        return gens.size <= numGens;
    }

}
