package parking

object Parking {
    private var spots = mutableListOf<Spot>()

    fun occupyFree(car: Car) {
        if (spots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val freeSpot: Spot? = spots.find { !it.isOccupied() }
        freeSpot?.let {
            it.car = car
            println("${car.color} car parked in spot ${freeSpot.index}.")
        } ?: println("Sorry, the parking lot is full.")

    }

    fun freeSpot(num: Int) {
        if (spots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        spots
            .find { it.index == num && it.isOccupied() }?.let {
                it.car = null
                println("Spot $num is free.")
            } ?: println("There is no car in spot ${num}.")

    }

    fun createParking(amount: Int) {
        spots.clear()
        spots = spots.apply {
            for (i in 1..amount) {
                this.add(Spot(null, i))
            }
        }
        println("Created a parking lot with $amount spots.")
    }

    fun getSpots(): List<Spot> {
        return spots.toList()
    }
}

data class Car(val color: String, val number: String)

class Spot(var car: Car?, val index: Int) {
    fun isOccupied(): Boolean {
        return this.car != null
    }
}