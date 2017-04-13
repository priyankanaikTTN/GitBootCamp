/**
 * Created by priyanka on 12/4/17.
 */

interface Pizza
{

    int cost();
}
class PeppyPaneerPizza implements Pizza
{
    @Override
    public int cost() {
        return 350;
    }
}
class FarmhousePizza implements Pizza
{
    @Override
    public int cost() {
        return 250;
    }
}
class MargheritaPizza implements Pizza
{
    @Override
    public int cost() {
        return 200;
    }
}
class ChickenPizza implements Pizza
{
    @Override
    public int cost() {
        return 400;
    }
}
abstract class  PizzaDecorator implements Pizza
{
    Pizza p;


    public int cost() {
        return 0;
    }
}

class Freshtomato extends PizzaDecorator
{

    public Freshtomato() {
    }

    public Freshtomato(Pizza p) {
        this.p=p;
    }

    @Override
    public int cost() {
        return p.cost()+30;
    }
}
class Jalapeno extends PizzaDecorator
{
    public Jalapeno() {
    }

    public Jalapeno(Pizza p)
    { this.p=p;}

    @Override
    public  int cost()
    { return p.cost()+45;}
}
class Barbeque extends  PizzaDecorator
{

    public Barbeque() {
    }

    public Barbeque(Pizza p) {
        this.p=p;
    }

    @Override
    public int cost() {
        return p.cost()+50;
    }
}

public class PizzaCorner {


    public static void main(String[] args) {


       Pizza p = new Barbeque(new Jalapeno(new PeppyPaneerPizza()));
        System.out.println("total cost :" + p.cost());
    }
}
