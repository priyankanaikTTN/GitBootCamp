/**
 * Created by priyanka on 20/4/17.
 */


class Q23 {


    public static void main(String[] args) {
        Map<String, Map<String, Integer>> m = ['Computing' : ['Computing' : 600, 'Information Systems': 300], 'Engineering' : ['Civil' : 200, 'Mechanical' : 100], 'Management' : ['Management' : 800] ]
        println "# of university departments: ${m.keySet().size()}"
        println "# of programs delivered by Computing departments: ${m.get("Computing").keySet().size()}"
        println "# of students enrolled in civil engineering: ${m.get("Engineering").get("Civil")}"
    }
}
