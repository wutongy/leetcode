
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


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);
        dict.remove(endWord);
        HashSet<String> forward = new HashSet<>(), backward = new HashSet<>();
        forward.add(beginWord);
        backward.add(endWord);
        int fStep = 1, bStep = 1;
        while (!forward.isEmpty()) {
            if (fStep <= bStep) {
                HashSet<String> newSet = new HashSet<>();
                for (String s : forward) {
                    char[] cs = s.toCharArray();
                    for (int i = 0; i < cs.length; ++i) {
                        char c = cs[i];
                        for (int j = 0; j < 26; ++j) {
                            if (c == ('a' + j)) {
                                continue;
                            }
                            cs[i] = (char)('a' + j);
                            String newStr = new String(cs);
                            if (backward.contains(newStr)) {
                                return fStep + bStep;
                            }
                            if (dict.contains(newStr)) {
                                newSet.add(newStr);
                                dict.remove(newStr);
                            }
                        }
                        cs[i] = c;
                    }
                }
                forward = newSet;
                ++fStep;
            } else {
                HashSet<String> temp = forward;
                forward = backward;
                backward = temp;
                int t = fStep;
                fStep = bStep;
                bStep = t;
            }
        }
        return 0;
    }
}
