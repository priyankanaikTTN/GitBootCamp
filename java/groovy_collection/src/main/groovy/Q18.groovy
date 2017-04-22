/**
 * Created by priyanka on 20/4/17.
 */
class Q18 {

    public static void main(String[] args) {

        Map m = new TreeMap<>()

        (1..10).each{ m.put("frnd${it}", it+10) }

        println "Map is: "+m

        println ""
        println "iterating with each{}"
        m.each { print "${it} " }
        println ""
        println "iterating with eachWithIndex entry object{}"
        m.eachWithIndex{ Map.Entry<String, Integer> entry, int i -> print "${entry} "}
        println ""
        println "iterating with each with key and value"
        m.each{ k,v -> print "${k}=${v} " }


    }

}
