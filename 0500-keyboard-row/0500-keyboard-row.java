class Solution {
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        for (int i = 0; i < words.length; i++) {
            String s = words[i].toLowerCase();
            boolean first = true, second = true, third = true;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!a.contains(ch + "")) first = false;
                if (!b.contains(ch + "")) second = false;
                if (!c.contains(ch + "")) third = false;
            }
            if (first || second || third) ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}