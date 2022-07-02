import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
       System.out.println(permutationList("", "abcd"));
       System.out.println(permutationCount("","abcd"));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        System.out.println(ch);
        for(int i=0;i<=p.length();i++){
            System.out.println("up: "+up+" p: "+p);
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            String fi = f+ch+s;
            System.out.println(fi+" :fi");
            permutation(f+ch+s, up.substring(1));
            System.out.println("One function call over");
        }
    }
    static ArrayList<String> permutationList(String p, String up){
        ArrayList<String> ans = new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f= p.substring(0, i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationList(f+ch+s, up.substring(1)));

        }
        return ans;
    }
    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count =0;
        char ch= up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count+permutationCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}
