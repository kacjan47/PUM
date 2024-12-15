package pl.edu.uwr.quizappkotlin

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

val questionList = listOf(
    Question("Jaką własność ciała określa stosunek masy do objętości?", listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"), 2),
    Question("Jaka planeta jest najbliższa Słońcu?", listOf("Wenus", "Mars", "Merkury", "Ziemia"), 2),
    Question("Który pierwiastek ma symbol 'O'?", listOf("Ołów", "Tlen", "Złoto", "Cynk"), 1),
    Question("Stolica Francji to?", listOf("Londyn", "Berlin", "Paryż", "Madryt"), 2),
    Question("Ile wynosi pierwiastek kwadratowy z 16?", listOf("2", "4", "8", "6"), 1),
    Question("Która liczba jest pierwsza?", listOf("9", "12", "11", "15"), 2),
    Question("Co jest stolicą Polski?", listOf("Warszawa", "Kraków", "Poznań", "Gdańsk"), 0),
    Question("Największy ocean to?", listOf("Atlantycki", "Spokojny", "Arktyczny", "Indyjski"), 1),
    Question("Ile nóg ma pająk?", listOf("6", "8", "10", "4"), 1),
    Question("Jaki kolor powstaje z połączenia niebieskiego i żółtego?", listOf("Czerwony", "Zielony", "Fioletowy", "Pomarańczowy"), 1)
)
