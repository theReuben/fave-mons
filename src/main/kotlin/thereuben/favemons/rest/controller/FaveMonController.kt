package thereuben.favemons.rest.controller

import DataReader
import DataService
import ValidationService
import data.FavPkmn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fave-mons")
class FaveMonController() {

    val dataReader = DataReader()
    val dataService = DataService()
    val validator = ValidationService()

    fun getDataList(): List<FavPkmn> {
        val dataList = dataReader.readCsv()

        val isValidTypes = validator.validateTypes(dataList)
        val isValidGens = validator.validateGens(dataList)

        val isValidData = isValidTypes && isValidGens

        if (!isValidData) {
            println("Data is not valid.")
            throw Exception("Data is not valid.")
        }

        return dataList
    }

    @GetMapping("/all")
    fun test(): List<FavPkmn> {
        return getDataList()
    }


}