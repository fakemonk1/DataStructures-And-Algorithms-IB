package greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ashish Gupta on 24/02/17.
 */
public class AssignMiceToHoles {

    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int ans = 0;
        for(int i = 0; i < a.size(); i++){
            ans = Math.max(ans, Math.abs(a.get(i) - b.get(i)));
        }
        return ans;
    }
}
