import java.util.Objects;

/*
[abcepwd]-->
1.[abc]:prefix
2.[pwd]:suffix
3.[abwd]:insert in the middle
*/
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");
        System.out.println(sentence2.length());
        int i = 0;
        int j = 0;
        while (i < sen1.length && j < sen2.length) {
            if (!sen1[i].equals(sen2[j])) {
                break;
            }
            i++;
            j++;
        }
        if (i == sen1.length || j == sen2.length) {
            return true;
        }
        int k = sen1.length - 1;
        int p = sen2.length - 1;
        while (k >= 0 && p >= 0) {
            if (!sen1[k].equals(sen2[p])) {
                break;
            }
            k--;
            p--;
        }
        if (k == -1 || p == -1) {
            return true;
        }
        return k < i || p < j;
    }

    public static void main(String[] args) {
        String a = "My name is Haley";
        String b = "My Haley";
        String c = "of";
        String d = "A lot of words";
        String e = "Eating right now";
        String f = "Eating";
        //System.out.println(new SentenceSimilarity().areSentencesSimilar(a,b));
        //System.out.println(new SentenceSimilarity().areSentencesSimilar(c,d));
        System.out.println(new SentenceSimilarity().areSentencesSimilar(e,f));
    }
}
