package thereuben.favemons.rest.app

import DataReader
import DataService
import ValidationService

fun main(args: Array<String>) {

    val dataReader = DataReader()
    val dataService = DataService()
    val validator = ValidationService()


    val dataList = dataReader.readCsv()

    val isValidTypes = validator.validateTypes(dataList)
    val isValidGens = validator.validateGens(dataList)

    val isValidData = isValidTypes && isValidGens

    if (!isValidData) {
        println("Data is not valid.")
        return
    }

    println("Number of chatters: " + dataService.numChatters(dataList))
    println("Number of unique mons: " + dataService.numUniqueMons(dataList))
    println("Number of unique mons by gen: " + dataService.numUniqueMonsPerGen(dataList))
    println("Number of unique mons by gen (% of gen): " + dataService.numUniqueMonsPerGenPercent(dataList))
    println("Fave gens: " + dataService.faveGens(dataList))
    println("Fave gens (%): " + dataService.faveGensPercent(dataList))
    println("Fave mons: " + dataService.faveMons(dataList))
    println("Fave primary types: " + dataService.favePrimaryTypes(dataList))
    println("Fave primary types (%): " + dataService.favePrimaryTypesPercent(dataList))
    println("Fave secondary types: " + dataService.faveSecondaryTypes(dataList))
    println("Fave secondary types (%): " + dataService.faveSecondaryTypesPercent(dataList))
    println("Fave total types: " + dataService.faveTotalTypes(dataList))
    println("Fave total types (%): " + dataService.faveTotalTypesPercent(dataList))
    println("Fave combined types : " + dataService.faveCombinedTypes(dataList))
    println("Number combined types : " + dataService.faveCombinedTypesNum(dataList))
    println("Monotypes not picked: " + dataService.monotypes(dataList))


}