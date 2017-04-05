package cs143;

/**
 * Main class used to test the SortedSet class.
 *
 * @author Linda Zuvich
 */
public class Project1 {

    /**
     * All tests performed here in main method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortedSet set = new SortedSet();
        //test insertion
        for (int i = 0; i < 10; i++) {
            if (set.add(new Player(String.valueOf((char) (i + 97)), i + 10)) != 0) {
                System.out.println("INSERTION FAIL");
                return;
            }
        }
        System.out.println("INSERTION PASS");
        //test growing array
        if (set.add(new Player("k", 9)) != 10) {
            System.out.println("GROW FAIL");
            return;
        }
        System.out.println("GROW PASS");
        //test duplicate
        if (set.add(new Player("D", 5)) != -1) {
            System.out.println("DUPLICATE FAIL");
            return;
        }
        System.out.println("DUPLICATE PASS");
        //test valid remove
        if (!set.remove("c")) {
            System.out.println("VALID REMOVE FAIL");
            return;
        }
        System.out.println("VALID REMOVE PASS");
        //test invalid remove
        if (set.remove("z")) {
            System.out.println("INVALID REMOVE FAIL");
            return;
        }
        System.out.println("INVALID REMOVE PASS");
        //test valid find
        if (set.find("g") != 3) {
            System.out.println("VALID FIND FAIL");
            return;
        }
        System.out.println("VALID FIND PASS");
        //test invalid find
        if (set.find("z") != -1) {
            System.out.println("INVALID FIND FAIL");
            return;
        }
        System.out.println("INVALID FIND PASS");
        //test valid get
        if (set.get(0).getScore() != 19) {
            System.out.println("VALID GET FAIL");
            return;
        }
        System.out.println("VALID GET PASS");
        //test invalid get
        if (set.get(100) != null) {
            System.out.println("INVALID GET FAIL");
            return;
        }
        System.out.println("INVALID GET PASS");
        //test toString method
        try {
            String str = set.toString();
            if (str.equals("[ (Player: j, Score: 19) (Player: i, Score: 18) "
                    + "(Player: h, Score: 17) (Player: g, Score: 16) "
                    + "(Player: f, Score: 15) (Player: e, Score: 14) "
                    + "(Player: d, Score: 13) (Player: b, Score: 11) "
                    + "(Player: a, Score: 10) (Player: k, Score: 9) ]")) {
                System.out.println("TOSTRING PASS");
            } else {
                System.out.println("TOSTRING FAIL");
            }
        } catch (Exception e) {
            System.out.println("TOSTRING FAIL");
        }
        //test proper capacity of array
        if (set.capacity() != 20) {
            System.out.println("SIMPLE CAPACITY FAIL");
            return;
        }
        System.out.println("SIMPLE CAPACITY PASS");
        for (int i = 0; i < 100; i++) {
            set.add(new Player((String.valueOf((char) (i + 97))) + i, i));
        }
        if (set.capacity() != 160) {
            System.out.println("COMPLEX CAPACITY FAIL");
            return;
        }
        System.out.println("COMPLEX CAPACITY PASS");
    }

}
