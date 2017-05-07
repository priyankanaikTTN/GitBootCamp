package enums
/**
 * Created by priyanka on 26/4/17.
 */
enum Visibility
{
    PUBLIC, PRIVATE

    static toString(String visible)
    {
        if(visible=='public'||visible=='PUBLIC')
        {
            return Visibility.PUBLIC
        }
        else if(visible=='private'||visible=='PRIVATE')
        {
            return Visibility.PRIVATE
        }
    }
}
