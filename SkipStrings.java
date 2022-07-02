public class SkipStrings {
    public static void main(String[] args) {
        System.out.println(skipString("nasbdsapplejgh", "apple"));
        System.out.println(skipApple("nasdjappleafg","apple"));
    }
    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(up.charAt(0)=='a'){
            return skip(up.substring(1));
        }
        else{
            return ch+skip(up.substring(1));
        }
    }
    static String skipString(String up, String remove){
        int ln = remove.length();
        //System.out.println(ln);
        if(up.isEmpty())
            return "";
        char ch = up.charAt(0);
        //System.out.println(ch);
        if(up.startsWith(remove)){
            System.out.println(ch);
            return skipString(up.substring(ln), remove);
        }
        else{
            System.out.println(ch);
            return ch+ skipString(up.substring(1), remove);
        }
    }
    static String skipApple(String up,String notRemoved){
        int ln = notRemoved.length();
        if(up.isEmpty())
            return "";
        char ch = up.charAt(0);
        if(up.charAt(0)=='a'&&!up.startsWith(notRemoved)){
            return skipApple(up.substring(1), notRemoved);
        }
        else{
            return ch+skipApple(up.substring(1), notRemoved);
        }
    }
}
