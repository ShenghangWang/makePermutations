import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shenghangwang
 */
public class Assign {

    static ArrayList<Integer> diskTypes = new ArrayList<>(Arrays.asList(2, 3));

    static ArrayList<ArrayList<Integer>> assignPillars (int pathSize){
        boolean[] isAssigned = new boolean[pathSize];
        ArrayList<ArrayList<Integer>> possibleAssignments = new ArrayList<>();
        ArrayList<Integer> assignments = new ArrayList<>();

            assignPillar(0, null, assignments, pathSize, possibleAssignments, isAssigned);

        return possibleAssignments;
    }

    static void assignPillar(int currentPillar, Integer assignment, ArrayList<Integer> assignemnts, int pathSize,
                      ArrayList<ArrayList<Integer>> possibleAssignments, boolean[] isAssigned){

        if(assignment != null){
            assignemnts.add(assignment);
        }
        //currentPillar++;
        if(currentPillar == pathSize){
            possibleAssignments.add(assignemnts);
            return;
        }
        //currentPillar++;
            for (int i=0; i<diskTypes.size(); i++){
                System.out.println("currentPillar: "  + currentPillar);

                assignPillar(currentPillar+1, (Integer) i, (ArrayList<Integer>)assignemnts.clone(), pathSize, possibleAssignments, isAssigned);
                System.out.println("currentPillar After: "  + currentPillar);
            }
        //currentPillar++;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> possibleAssignments = assignPillars(2);
        for(ArrayList<Integer> assignments :  possibleAssignments){
            System.out.println(assignments);
        }
        System.out.println(possibleAssignments.size());
    }
}
