package enums
/**
 * Created by priyanka on 26/4/17.
 */
enum Seriousness
{

    SERIOUS, VERY_SERIOUS, CASUAL

    static toString(String serious)
    {
        if(serious=='serious'||serious=='SERIOUS')
        {
            return Seriousness.SERIOUS
        }
        else if(serious=='very_serious'||serious=='VERY_SERIOUS')
        {
            return Seriousness.VERY_SERIOUS
        }
        else if(serious=='casual'||serious=='CASUAL')
        {
            return Seriousness.CASUAL
        }
    }
}
