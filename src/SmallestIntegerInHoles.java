//Find the smallest positive integer in given holes
//number with 0 hole: 1,2,3,5,7
//number with 1 hole: 0,4,6,9
//number with 2 holes: 8
public class SmallestIntegerInHoles {
    public String FindSmallestPosIntInHoles(int holes){
        //if holes % 2 == 0, holes/2 "8"
        //if holes % 2 != 0, one "4" , rest digits are "8"
        String ans = "";
        if(holes == 0){
            return "1";
        }
        if(holes == 1){
            return "4";
        }
        if(holes == 2){
            return "8";
        }
        if(holes % 2 == 0){
            for(int i = 1; i <= holes/2; i++){
                ans += "8";
            }
        }
        else{
            ans = "4";
            for(int j = 1; j <= holes/2; j++){
                ans += "8";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int example = 6;
        SmallestIntegerInHoles ex = new SmallestIntegerInHoles();
        System.out.println(ex.FindSmallestPosIntInHoles(example));
    }
}
