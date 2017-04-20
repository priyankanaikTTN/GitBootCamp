/**
 * Created by priyanka on 18/4/17.
 */
class HourMinute {

    int hours;
    int minutes;

    int getHours() {
        return hours
    }

    void setHours(int hours) {
        this.hours = hours
    }

    int getMinutes() {
        return minutes
    }

    void setMinutes(int minutes) {
        this.minutes = minutes
    }

    HourMinute plus(HourMinute hourMinute)
    {
        HourMinute hourMinute1 = new HourMinute();

        hourMinute1.minutes=(this.minutes+hourMinute.minutes)%60;

        hourMinute1.hours=(int)(this.hours+hourMinute.hours)%12+(this.minutes+hourMinute.minutes)/60

       hourMinute1;
    }

    HourMinute minus(HourMinute hourMinute)
    {  HourMinute hourMinute1 = new HourMinute()
        hourMinute1.minutes = this.minutes-hourMinute.minutes;

        hourMinute1.hours = this.hours-hourMinute.minutes;

        hourMinute1

    }

    public static void main(String[] args) {


        HourMinute hourMinute1=new HourMinute(hours: 22,minutes: 32);


        HourMinute hourMinute2= new HourMinute(hours: 6,minutes: 12);


        HourMinute hourMinute3 = hourMinute1+hourMinute2;


        println("Addition")
        println("hour : $hourMinute1.hours , minutes : $hourMinute1.minutes")
        println("hour : $hourMinute2.hours , minutes : $hourMinute2.minutes")
        println("hour : $hourMinute3.hours , minutes : $hourMinute3.minutes")

        hourMinute3= hourMinute1-hourMinute2;

        println("Subtraction")
        println("hour : $hourMinute1.hours , minutes : $hourMinute1.minutes")
        println("hour : $hourMinute2.hours , minutes : $hourMinute2.minutes")
        println("hour : $hourMinute3.hours , minutes : $hourMinute3.minutes")







    }
}
