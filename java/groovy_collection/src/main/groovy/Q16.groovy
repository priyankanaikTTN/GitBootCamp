/**
 * Created by priyanka on 24/4/17.
 */
class Q16 {


    public static void main(String[] args) {
        Stack s = new Stack(['Groovy', 'is', 'great!']);
        println s
        println s.pop()

        s.push('rocks!')

        println s

    }
}

class Stack {
    List list = []

    Stack(list){
        this.list = list
    }

    public void push(def obj){
        list.push(obj)
    }

    public def pop(){
        return list.pop()
    }

    public def top(){
        return list.last()
    }


    @Override
    public String toString() {
        return "Stack{"+ list + "}";
    }
}