import util.LinkedList;

import java.util.Arrays;

public class LeastCommonSubsequence {
    public static void main(String[] args) {
        String u = "party";
        String v = "carrot";
        LinkedList<Character>[][] S = new LinkedList[u.length()+1][v.length()+1];
        for (int j = 0; j < S.length; j++) {
            S[j][0] = new LinkedList<>();
        }
        for (int k = 0; k < S[0].length; k++) {
            S[0][k] = new LinkedList<>();
        }

        for (int j = 1; j < S.length; j++) {
            for (int k = 1; k < S[j].length; k++) {
                S[j][k] = (S[j-1][k].length() >= S[j][k-1].length()) ? S[j-1][k] : S[j][k-1];
                if (u.charAt(j-1) == v.charAt(k-1)) {
                    S[j][k] = LinkedList.shallowCopyOf(S[j-1][k-1]);
                    S[j][k].add(u.charAt(j-1));
                }
            }
        }

        for (LinkedList[] l : S) {
            System.out.println(Arrays.toString(l));
        }

        System.out.println(S[u.length()][v.length()]);
    }
}
