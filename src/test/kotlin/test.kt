import zone.nora.moulberry.Colour
import zone.nora.moulberry.switch
import java.awt.Color

fun main() {
    switch(Colour.RED) {
        case(Colour.BLACK) {
            println("nope")
        }
        case(Color.PINK, Color.MAGENTA) {
            println("keep going")
        }
        case(Colour(0xff0000), fallthrough = true) {
            println("There we go! :)")
        }
        case(Colour.YELLOW, fallthrough = false) {
            println("this will run regardless because fallthrough :)")
        }
        default {
            println("default statement")
        }
    }
}