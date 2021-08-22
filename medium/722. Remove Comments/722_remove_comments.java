import java.util.ArrayList;
import java.util.List;

class Solution {

    private void helper(List<String> result , StringBuilder sb){
        if (sb.length() > 0) {
            result.add(sb.toString());
            sb.setLength(0);
        }
    }

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();

        boolean inScope = true;
        StringBuilder stringBuilder = new StringBuilder();

        for (String line : source) {
            char[] ar = line.toCharArray();
            int m = ar.length;
            int i = 0;
            while (i < m) {
                if (inScope&&(i + 1 < m) && ("/*".equals(line.substring(i, i + 2)))) {
                    inScope=false;
                    i+=2;
                } else if (inScope&&(i + 1 < m) && ("//".equals(line.substring(i, i + 2)))) {
                    helper(result, stringBuilder);
                    break;
                } else if (inScope) {
                    stringBuilder.append(ar[i]);
                    if (i == m - 1) {
                    	helper(result, stringBuilder);
                    }
                    i++;
                } else if(!inScope && (i + 1 < m) && ("*/".equals(line.substring(i, i + 2)))) {
                    inScope = true;
                    if (i == m - 2) {
                    	helper(result, stringBuilder);
                    }
                    i += 2;
                } else{
                    i++;
                }
                
            }

        }


        return result;

    }
}