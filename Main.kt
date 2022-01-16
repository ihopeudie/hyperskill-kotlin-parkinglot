package parking

import kotlin.system.exitProcess

fun main() {
    while (true) {
        val split = readLine()!!.split("\\s+".toRegex())
        when (split[0]) {
            "create" -> Parking.createParking(split[1].toInt())
            "status" -> StatisticService.printStatus()
            "park" -> Parking.occupyFree(Car(split[2], split[1]))
            "leave" -> Parking.freeSpot(split[1].toInt())
            "reg_by_color" -> StatisticService.printRegByColor(split[1])
            "spot_by_color" -> StatisticService.printSpotByColor(split[1])
            "spot_by_reg" -> StatisticService.printSpotByReg(split[1])
            "exit" -> exitProcess(0)
            else -> throw Exception("unknown command")
        }
    }
}
