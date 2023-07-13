package thereuben.favemons.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("api/mons")
class FaveMonController {

    @GetMapping("/")
    fun test(): String {
        return "test"
    }


}