
#include <vector>
using namespace std;

class Solution {
    
    inline static const int ALPHABET_SIZE = 26;
    inline static const char EMPTY {'\u0000'};

public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> allWordsThatMatchPattern;
        for (const auto& word : words) {
            if (wordMatchesPattern(word, pattern)) {
                allWordsThatMatchPattern.push_back(word);
            }
        }
        return allWordsThatMatchPattern;
    }

private:
    bool wordMatchesPattern(const string& word, const string& pattern) {
        array<char, ALPHABET_SIZE> patternToWord{};
        array<char, ALPHABET_SIZE> wordToPattern{};

        for (int i = 0; i < word.length(); ++i) {
            char p = pattern[i];
            char w = word[i];

            if ((patternToWord[p - 'a'] != EMPTY && patternToWord[p - 'a'] != w)
                    || (wordToPattern[w - 'a'] != EMPTY && wordToPattern[w - 'a'] != p)) {
                return false;
            }
            patternToWord[p - 'a'] = w;
            wordToPattern[w - 'a'] = p;
        }
        return true;
    }
};
