package org.example

import kotlin.random.Random

class Quoter {
    companion object {
        private val partyQuotes = arrayOf(
            "You will work for a while, you will be caught, you will confess, and then you will die… ",
            "You must try harder. It is not easy to become sane.",
            "We do not merely destroy our enemies; we change them.",
            "BB controls matter because he controls the mind. Reality is inside the skull.",
            "If you want a picture of the future, imagine a boot stamping on a human face – for ever.",
            "We shall abolish the orgasm.",
            "You must love Big Brother. It is not enough to obey him: you must love him.",
            "Who controls the past controls the future. Who controls the present controls the past.",
            "We shall meet in the place where there is no darkness.",
            "In the face of pain there are no heroes.",
            "If both the past and the external world exist only in the mind, and if the mind itself is controllable - what then?",
            "Under the spreading chestnut tree I sold you and you sold me:\n" +
                    "There lie they, and here lie we\n" +
                    "Under the spreading chestnut tree.")

        fun shouldBotRespond(): Boolean {
            return Random.nextDouble(0.0, 100.0) <= 0.5
        }

        fun getRandomMessage(): String {
            return partyQuotes.random()
        }
    }

}