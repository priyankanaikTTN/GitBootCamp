/**
 * Created by priyanka on 20/4/17.
 */
class Q17 {
    public static void main(String[] args) {

        Map<String, Integer> m = new TreeMap<>();

        (1..10).each{ m.put("frnd${it}", it+10) }

        println m
    }
}
