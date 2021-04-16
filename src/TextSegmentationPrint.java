import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TextSegmentationPrint {
    Stack<String> ans = new Stack();
    public String[] dic;//=new String();
    public String bank;//=new String("iloveicecreamandmango");
    int n;
    List dicc;

    TextSegmentationPrint(String[] dict, String bankk) {
        dic = dict;
        dicc = Arrays.asList(dic);
        bank = bankk;
        n = bank.length();
    }

    boolean isWord(int i, int j) {

        if (dicc.contains(bank.substring(i, j + 1))) {
            return true;
        }
        ;
        return false;

    }

    boolean isSplittable(int i) {

        if (i >= n) {
            return true;
        }
        for (int j = i; j < n; j++) {
            if (isWord(i, j)) {
                ans.push(bank.substring(i, j + 1));
                if (isSplittable(j + 1)) {
                    return true;
                }
                ans.pop();

            }

        }

        return false;
    }

    Stack<String> printt() {
        for (String s:
             ans) {
            System.out.print(s+" ");
        }

        return ans;
    }


    public static void main(String[] args) {
        String[] dic = createDictionaryArray();
        String s = "hiloveyouwhereareyou";
        String bank = new String(s.toLowerCase());
        TextSegmentationPrint test = new TextSegmentationPrint(dic, bank);

        if (test.isSplittable(0)) {
            System.out.println(test.printt());
        } else {
            System.out.println(false);
        }


    }

    static String[] createDictionaryArray() {
        List<String> listDictionary = new ArrayList<String>();
        BufferedReader reader;

        try {
            ClassLoader loader = TextSegmentationPrint.class.getClassLoader();
            File file = new File("EnglishWords");
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                listDictionary.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Do Something
        listDictionary.removeIf(name -> name.length() < 2);
        return listDictionary.toArray(new String[0]);
    }
}