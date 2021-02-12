import zone.nora.moulberry.Colour
import zone.nora.moulberry.switch

fun main() {
    switch(Colour.RED) {
        case(Colour.BLACK) {
            println("nope")
        }
        case("string", "uu") {
            println("keep going")
        }
        case(Colour(0xff0000)) {
            println("There we go! :)")
        }
        default {
            println("default statement")
        }
    }
}