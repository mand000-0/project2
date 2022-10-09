import kotlin.math.*


class Point (val x: Double, val y: Double)

class Rectangle(val p1: Point, val p2: Point){
    val left = java.lang.Double.min(p1.x, p2.x)
    val right = java.lang.Double.max(p1.x, p2.x)
    val bottom = java.lang.Double.min(p1.y, p2.y)
    val top = java.lang.Double.max(p1.y, p2.y)

    init{
        if (this.left==this.right || this.bottom == this.top){
            throw IllegalArgumentException()

        }
    }

    fun overlappingRectangle(r: Rectangle): Rectangle{
        val xa:Double
        val xb:Double
        val ya:Double
        val yb:Double

        xa = max(this.left, r.left)
        xb = min(this.right, r.right)
        ya = max(this.bottom, r.bottom)
        yb = min(this.top, r.top)

        if (yb <= ya || xb<=xa) throw NoSuchElementException()
        val a = Point(xa,ya)
        val b = Point(xb,yb)

        return Rectangle(a,b)

    }
    fun printRectangle(){
        println("직사각형 좌:${this.left}, 우:${this.right}, 하:${this.bottom}, 상:${this.top}")



    }
}

fun main() {
    try {
        println("직사각형 1의 대각점 1의 좌표를 입력하시오: ")
        val p1X = readLine()!!.toDouble()
        val p1Y = readLine()!!.toDouble()
        println("직사각형 1의 대각점 2의 좌표를 입력하시오: ")
        val p2X = readLine()!!.toDouble()
        val p2Y = readLine()!!.toDouble()
        val r1 = Rectangle(Point(p1X, p1Y), Point(p2X, p2Y))
        println("직사각형 2의 대각점 1의 좌표를 입력하시오: ")
        val p3X = readLine()!!.toDouble()
        val p3Y = readLine()!!.toDouble()
        println("직사각형 1의 대각점 2의 좌표를 입력하시오: ")
        val p4X = readLine()!!.toDouble()
        val p4Y = readLine()!!.toDouble()
        val r2 = Rectangle(Point(p3X, p3Y), Point(p4X, p4Y))
        r1.overlappingRectangle(r2).printRectangle()
    } catch (e: IllegalArgumentException) {
        println("직사각형이 잘못 입력되었습니다.")
    } catch (e: NoSuchElementException) {
        println("직사각형이 겹치지 않습니다.")
    }
}