/**
 * Created by priyanka on 20/4/17.
 */
class Q14 {


        public static void main(String[] args) {
            String s = "abcdeaaaabbbbcccccdd"
            char a='a'
            println " character occurences of a :"+getOccurences(s, a)
        }

        public static int getOccurences(String s, Character c) {
            int counter = 0;
            s.each { chrctr -> if (chrctr.charAt(0) == c) counter++ }
            return counter;
        }
}
