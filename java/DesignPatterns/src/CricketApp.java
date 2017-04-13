import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.security.auth.Subject;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by priyanka on 12/4/17.
 */

class State
{ float totalscore;
    int totalMatches;
    float runrate;

    public State(float totalscore, int totalMatches, float runrate) {
        this.totalscore = totalscore;
        this.totalMatches = totalMatches;
        this.runrate = runrate;
    }

    public float getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(float totalscore) {
        this.totalscore = totalscore;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public float getRunrate() {
        return runrate;
    }

    public void setRunrate(float runrate) {
        this.runrate = runrate;
    }
}
abstract class CricketData extends java.util.Observable {


    public abstract void displayScore();
}

class CricketDataConcrete extends CricketData
{    State s;
    List<Displayer> list;

    public CricketDataConcrete(float totalscore, int totalMatches, float runrate) {
        this.s=new State(totalscore,totalMatches,runrate);
        this.list= new ArrayList<Displayer>();

    }


    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);

        list.add((Displayer) o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();

        for (Displayer d: list
             ) {
            d.update(this,this.s);

        }

    }

    @Override
    public void displayScore() {

       notifyObservers();

    }


}

abstract class Displayer implements Observer
{



}

class CurrentScore extends Displayer
{


    @Override
    public void update(java.util.Observable o, Object arg) {

         State s = (State) arg;
        System.out.println("Current Score :"+s.getTotalscore());
        System.out.println("Current Matches :"+s.getRunrate());
    }
}

class AverageScore extends Displayer
{


    @Override
    public void update(java.util.Observable o, Object arg) {

        State s=(State)arg;

        float avg = s.getTotalscore()/s.getTotalMatches();
        System.out.println("Average Score :"+avg);

    }
}
public class CricketApp {

    public static void main(String[] args) {


        CricketData cricketData = new CricketDataConcrete(1050,6, (float) 6.9);

        cricketData.addObserver(new CurrentScore());
        cricketData.addObserver(new AverageScore());

        cricketData.displayScore();

    }



}



