package com.berliana.taskfrontendil.model

import com.berliana.taskfrontendil.R

data class Drink (
    val id: Long,
    val image: Int,
    val title: String,
    val price: String,
    val description: String
)

val dummyDrink = listOf(
    Drink(
        1,
        R.drawable.drink1,
        "Strawberry Frappucino",
        "Rp 20.000",
        "Ini adalah minuman yang menyegarkan dan manis, yang memiliki campuran unik antara kopi espresso, susu, sirup stroberi, dan es. Rasanya kaya dan segar, dengan sentuhan manis dari stroberi yang menyatu dengan cita rasa kopi yang khas. Biasanya disajikan dengan whipped cream di atasnya untuk menambahkan kelembutan dan dekorasi."),
    Drink(
        2,
        R.drawable.drink2,
        "Pisvocado",
        "Rp 20.000",
        "Pisvocado adalah minuman yang menggabungkan dua bahan sehat, yaitu pisang dan alpukat. Kombinasi ini menciptakan rasa yang kaya dan kreami dengan tambahan nutrisi yang baik. Mungkin juga disajikan dengan susu atau es krim untuk menambahkan kelembutan dan rasa."),
    Drink(
        3, R.drawable.drink3,
        "Matcha Frappucino",
        "Rp 20.000",
        "Ini adalah minuman dingin yang dibuat dengan bubuk matcha, susu, gula, dan es. Matcha memberikan rasa teh hijau yang khas dengan sedikit keasaman yang menyegarkan. Susu dan gula menyeimbangkan rasa teh hijau yang kuat, menciptakan minuman yang lezat dan menyegarkan."),
    Drink(
        4,
        R.drawable.drink4,
        "Vanilla Frappucino",
        "Rp 15.000",
        "Minuman ini memiliki rasa manis dan lembut dari vanilla yang dipadukan dengan kopi espresso yang kaya, susu, gula, dan es. Rasanya sangat memuaskan dengan sentuhan kelembutan dari vanilla dan kekuatan kopi yang menyegarkan."),
    Drink(5,
        R.drawable.drink5,
        "Peppermint Mocca",
        "Rp 25.000",
        "Ini adalah minuman kopi yang memadukan cokelat, peppermint (menta), susu, dan es. Rasanya kaya dengan rasa cokelat yang manis dan sentuhan menyegarkan dari peppermint. Ditambah dengan whipped cream dan serbuk cokelat di atasnya, menciptakan minuman yang lezat dan menenangkan."),
    Drink(6,
        R.drawable.drink6,
        "Lotus Coffee Latte",
        "Rp 15.000",
        "Ini adalah minuman kopi yang dicampur dengan sirup lotus yang memberikan sentuhan karamel yang kaya dan beraroma. Dicampur dengan susu dan espresso, menciptakan minuman yang kaya, lembut, dan beraroma."),
    Drink(
        7,
        R.drawable.drink7,
        "Java Chip Frappucino",
        "Rp 25.000",
        "Minuman dingin ini memiliki campuran kopi espresso, susu, es, dan potongan kecil cokelat. Rasanya menyenangkan dengan sentuhan kopi yang kuat dan manisnya cokelat. Dihiasi dengan whipped cream, menciptakan minuman yang nikmat dan lezat."),
    Drink(
        8,
        R.drawable.drink8,
        "Con Panna",
        "Rp 25.000",
        "Ini adalah minuman kopi espresso yang sederhana namun lezat, yang disajikan dengan whipped cream di atasnya. Rasanya kaya dan beraroma dengan sentuhan manis dan lembut dari whipped cream."),
    Drink(
        9,
        R.drawable.drink9,
        "Espresso",
        "Rp 25.000",
        "Espresso adalah minuman kopi yang kuat dan pekat, yang diseduh dengan mengekstrak air panas melalui bubuk kopi yang halus. Rasanya intens dan kaya, dengan sedikit rasa pahit yang menyegarkan."),
    Drink(
        10,
        R.drawable.drink10,
        "Glace Coffee",
        "Rp 15.000",
        "Ini adalah minuman kopi dingin yang menyegarkan, yang mungkin disajikan dengan es batu dan kadang-kadang ditambahkan susu atau sirup untuk rasa tambahan."),
    Drink(
        11,
        R.drawable.drink11,
        "Black Sesame",
        "Rp 20.000",
        "Minuman ini mungkin memiliki rasa yang unik dan berbeda, karena menggunakan biji wijen hitam yang dicampur dengan kopi atau susu. Rasanya bisa kaya dan beraroma, dengan sentuhan gurih dan nutty dari biji wijen hitam."),
    Drink(
        12,
        R.drawable.drink12,
        "Classic Afogato",
        "Rp 20.000",
        "Ini adalah hidangan penutup klasik yang terdiri dari es krim vanilla yang dituangi dengan espresso panas. Es krim meleleh di bawah panasnya espresso, menciptakan kombinasi rasa yang lezat antara manisnya es krim dan kekuatan kopi espresso."),
)