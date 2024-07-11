package com.example.quizapp

object Constants {

    fun getQuestion(): ArrayList<Question>{

        var QuestioList = ArrayList<Question>()

        var QesOne = Question(
            1,"Which Country became champion in T20 World Cup 2024?",
            "India",
            "Australia",
            "England",
            "Pakistan",
            1
        )
        var Qestwo = Question(
            1,"who is the current prime minister in pakistan?",
            "Asim Munire",
            "Imran khan",
            "Zardari",
            "Shahbaz Sharif",
            4
        )
        var Qesthree = Question(
            1,"who is the current prime minister? in India?",
            "Rahul Gandi",
            "Kohli",
            "Narinder Nodi",
            "Sharuk Khan",
            3
        )
        var Qesfour = Question(
            1,"who was the Man of the Tournament in T20 World Cup 2024?",
            "de Kock",
            "Jasprit Bumrah",
            "Babar Azam",
            "Mitchell Starc",
            2
        )
        var Qesfive = Question(
            1,"how was the Leading run scorers in T20 World Cup 2024?",
            "travis Head",
            "Rohit Sharma",
            "Gurbaz",
            "Babar Azam",
            3
        )
        var Qessix = Question(
            1,"how was the Highest wicket takers in T20 World Cup 2024?",
            "Farooqi",
            "Arshdeep singh",
            "Rashid Khan",
            "Muhammad Amir",
            1
        )
        QuestioList.add(QesOne)
        QuestioList.add(Qestwo)
        QuestioList.add(Qesthree)
        QuestioList.add(Qesfour)
        QuestioList.add(Qesfive)
        QuestioList.add(Qessix)
        return QuestioList
    }

}