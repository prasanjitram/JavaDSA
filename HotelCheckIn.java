import java.util.Arrays;

public class HotelCheckIn {
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 5, 5};
        int[] arr1 = {4, 5, 12, 9, 12};
        System.out.println(maxPeople(arr,arr1));
    }
    public static int maxPeople(int[] start,int[] end){
        Arrays.sort(start);
        Arrays.sort(end);
        int max=1;
        int people=0;
        int time = start[0];
        int n = start.length;
        int i=1,j=0;
        while(i<n&&j<n){
            if(start[i]<=end[j]){
                people+=1;
                if(people>max){
                    max=people;
                    time=start[i];
                }
                i++;
            }
            else{
                people-=1;
                j++;
            }
        }
        return time;
    }
}
