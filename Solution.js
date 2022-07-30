
/**
 * @param {string[]} words
 * @param {string} pattern
 * @return {string[]}
 */
var findAndReplacePattern = function (words, pattern) {
    const allWordsThatMatchPattern = [];
    for (let word of words) {
        if (wordMatchesPattern(word, pattern)) {
            allWordsThatMatchPattern.push(word);
        }
    }
    return allWordsThatMatchPattern;
};

/**
 * @param {string} word
 * @param {string} pattern
 * @return {boolean}
 */
function wordMatchesPattern(word, pattern) {
    const patternToWord = new Map();
    const wordToPattern = new Map();

    for (let i = 0; i < word.length; ++i) {
        const p = pattern.charAt(i);
        const w = word.charAt(i);
        if ((patternToWord.has(p) && patternToWord.get(p) !== w)
                || (wordToPattern.has(w) && wordToPattern.get(w) !== p)) {
            return false;
        }
        patternToWord.set(p, w);
        wordToPattern.set(w, p);
    }
    return true;
}
