class WordDictionary {
public:
    struct trieNode {
        bool isWord;
        trieNode* children[26];
        trieNode(): isWord(false) {
            for (int i = 0; i < 26; i++) {
                children[i] = NULL;
            }
        }
    };

    trieNode *root;
    /** Initialize your data structure here. */
    WordDictionary() {
        root = new trieNode();
    }

    /** Adds a word into the data structure. */
    void addWord(string word) {
        trieNode *head = root;
        for (int i = 0; i < word.size(); i++) {
            int idx = word[i] - 'a';
            if (!head->children[idx]) {
                head->children[idx] = new trieNode();
            }
            head = head->children[idx];
        }
        head->isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        deque<trieNode*> Q;
        Q.push_back(root);
        for (int i = 0; i < word.size(); i++) {
            int size = Q.size();
            if (word[i] >= 'a' && word[i] <= 'z') {
                int idx = word[i] - 'a';
                for (int j = 0; j < size; j++) {
                    trieNode* tp = Q.front();
                    Q.pop_front();
                    if (tp->children[idx]) {
                        Q.push_back(tp->children[idx]);
                    }
                }
            } else if (word[i] == '.') {
                for (int j = 0; j < size; j++) {
                    trieNode* tp = Q.front();
                    Q.pop_front();
                    for (int k = 0; k < 26; k++) {
                        if (tp->children[k]) {
                            Q.push_back(tp->children[k]);
                        }
                    }
                }
            }
            if (Q.empty()) return false;
        }

        for (auto it = Q.begin(); it != Q.end(); it++) {
            if ((*it)->isWord) {
                return true;
            }
        }
        return false;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */