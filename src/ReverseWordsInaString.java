public class ReverseWordsInaString {
    public String reverseWorlds(String s){
        String[] example = s.split("\\s+");
        StringBuilder temp = new StringBuilder();

        for(int i = example.length-1; i >= 0; i--){
                temp.append(example[i]);
                temp.append(" ");
        }
      return temp.toString().trim();
    }

    public static void main(String[] args) {
        String ex = "a good   example";
        String ex2 = "hello world  ";
        String ex3 = "the sky is blue";
        ReverseWordsInaString ob = new ReverseWordsInaString();
        System.out.println(ob.reverseWorlds(ex));
        System.out.println(ob.reverseWorlds(ex2));
        System.out.println(ob.reverseWorlds(ex3));
    }
}
