object Problem3{
    def main(args : Array[String]) : Unit = {
        val scores = List(90, 80, 70, 60, 50)

        val uniqueScores = scores.distinct
        val passingScores = uniqueScores.filter(score => score >= 60)
        val gracedScores = passingScores.map(score => if (score < 70) score + 5 else score)
        val totalSum = gracedScores.sum

        println(s"Total sum of graced passing scores: $totalSum")
        println(s"Graced passing scores: $gracedScores")
        println(s"Unique passing scores: $passingScores")
        println(s"Original scores: $scores")
        println(s"Distinct scores: $uniqueScores")
        
    }
}