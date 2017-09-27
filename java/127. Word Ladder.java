
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wlist = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        int length = 1;
        start.add(beginWord);
        end.add(endWord);
        wlist.remove(beginWord);
        wlist.remove(endWord);
        while (!start.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String word : start) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; ++i) {
                    char old = wordArray[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wordArray[i] = c;
                        String str = String.valueOf(wordArray);
                        if (end.contains(str)) {
                            return length + 1;
                        }
                        if (wlist.contains(str)) {
                            next.add(str);
                            wlist.remove(str);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            start = next.size() < end.size() ? next : end;
            end = start.size() < end.size() ? end : next;
            ++length;
        }
        return 0;
    }
}
