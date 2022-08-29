import java.util.Arrays;

public class URLify {
    public static String replaceSpace(String s, int length) {
        char[] originString = s.toCharArray();
        int numOfSpace = 0;
        for (int i = 0; i < length; i++) {
            if (originString[i] == ' ') {
                numOfSpace++;
            }
        }
        int newStringLength = numOfSpace * 2 + length;
        char[] resultString = new char[newStringLength];
        int pointerForResult = 0;
        for (int j = 0; j < length; j++) {
            if (originString[j] == ' ') {
                resultString[pointerForResult] = '2';
                resultString[pointerForResult + 1] = '0';
                resultString[pointerForResult + 2] = '%';
                pointerForResult += 3;
            }
            resultString[pointerForResult] = originString[j];
            pointerForResult++;
        }
        return new String(resultString);
    }

    public static void main(String[] args) {
        String example = "Mr John Smith ";
        int length = 13;
        System.out.println(replaceSpace(example,length));
    }
}
