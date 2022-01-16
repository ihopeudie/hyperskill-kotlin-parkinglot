package parking

object StatisticService {
    fun printRegByColor(color: String) {
        if (Parking.getSpots().isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val carNumbers = Parking.getSpots()
            .filter { it.isOccupied() }
            .filter { it.car?.color.contentEquals(color, true) }
            .map { it.car!!.number }
        println(
            if (carNumbers.isNotEmpty()) carNumbers.joinToString(", ")
            else "No cars with color $color were found."
        )
    }

    fun printSpotByColor(color: String) {
        if (Parking.getSpots().isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val spotNumbers = Parking.getSpots()
            .filter { it.isOccupied() }
            .filter { it.car?.color.contentEquals(color, true) }
            .map { it.index }
        println(
            if (spotNumbers.isNotEmpty()) spotNumbers.joinToString(", ")
            else "No cars with color $color were found."
        )
    }

    fun printSpotByReg(num: String) {
        if (Parking.getSpots().isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        Parking.getSpots()
            .filter { it.isOccupied() }
            .find { it.car?.number?.equals(num) ?: false }
            ?.let {
                println(it.index)
            } ?: println("No cars with registration number $num were found.")
    }

    fun printStatus() {
        if (Parking.getSpots().isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        if (Parking.getSpots().none { it.isOccupied() }) {
            println("Parking lot is empty.")
            return
        }
        for (spot in Parking.getSpots()) {
            spot.car?.let {
                println("${spot.index} ${it.number} ${it.color}")
            }
        }
    }
}