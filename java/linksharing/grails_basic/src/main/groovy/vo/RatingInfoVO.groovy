package vo

/**
 * Created by priyanka on 7/5/17.
 */
class RatingInfoVO {

    Integer totalVotes
    Integer averageScore
    Integer totalScore

    @Override
    String toString() {
        return "${totalVotes}, ${averageScore}, ${totalScore}"
    }
}
