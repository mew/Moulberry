
import zone.nora.moulberry.Colour
import zone.nora.moulberry.switch

fun main() {
    switch(Colour.RED) {
        case(Colour.BLACK) {
            println("nope")
        }
        case(Colour.PINK, Colour.MAGENTA) {
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