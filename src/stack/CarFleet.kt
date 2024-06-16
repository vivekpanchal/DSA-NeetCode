package stack

/**
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val cars= mutableListOf<car>()
    for(i in position.indices){
        cars.add(car(position[i],(target-position[i]).toDouble()/speed[i]))
    }
    cars.sortBy { it.position }
    var fleets=0
    var lastTime=0.0
    for(i in cars.size-1 downTo 0){
        if(cars[i].timeToTarget>lastTime){
            println("time to target: ${cars[i].timeToTarget} || last time: $lastTime")
            fleets++
            lastTime=cars[i].timeToTarget
        }
    }
    return fleets
}

class car(
    val position:Int,
    val timeToTarget:Double
)



fun main() {
    val target=12
    val position = intArrayOf(10,8,0,5,3)
    val speed = intArrayOf(2,4,1,1,3)
    println(carFleet(target,position,speed))
}