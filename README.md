# Moulberry
library for moul berry :        )  
!["why doesnt switch work in kotlin" - moulberry](https://i.imgur.com/6181ZWh.png)
## code
```kotlin
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
```
also adds a `Colour` object which is identical to `Color` because why not :^)