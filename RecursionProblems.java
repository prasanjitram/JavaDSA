import java.util.ArrayList;

public class RecursionProblems {
    int count=0;
    public static void main(String[] args) {
        RecursionProblems obj = new RecursionProblems();
        //System.out.println(obj.numRollsToTarget(30,30,500));
    }
    
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        ans = numPad("", digits);
        return ans;
    }

    static String[] combination = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static ArrayList<String> numPad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = (up.charAt(0) - '0');
        ArrayList<String> ans = new ArrayList<>();
        String comb = combination[digit];
        for (int i = 0; i < comb.length(); i++) {
            char ch = comb.charAt(i);
            ans.addAll(numPad(p + ch, up.substring(1)));
        }

        return ans;
    }
    static ArrayList<String> dice(String p, int target){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i =1;i<=6&&i<=target;i++){
            ans.addAll(dice(p+i, target-i));
        }
        return ans;
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        return diceRoll("", target, n, k);
    }

    public int diceRoll(String p, int target, int n, int faces) {
        if(target==0){
            if(p.length()==n)
                count++;
            return count;
        }
        for(int i=1;i<=faces&&i<=target;i++){
            count=  diceRoll(p+i, target-i, n, faces);
        }
        return count;
    }
}
