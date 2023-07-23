package thereuben.favemons.rest.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
import thereuben.favemons.rest.controller.FaveMonController

@ComponentScan(basePackageClasses = [FaveMonController::class])
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class FaveMonsApplication

fun main(args: Array<String>) {
	runApplication<FaveMonsApplication>(*args)

}
