#include <string.h>

int lengthOfLongestSubstring(char *s) {
    int lastIndex[256];  
    for (int i = 0; i < 256; i++)
        lastIndex[i] = -1;

    int maxLen = 0;
    int start = 0;      

    for (int i = 0; s[i] != '\0'; i++) {
       
        if (lastIndex[(unsigned char)s[i]] >= start) {
            start = lastIndex[(unsigned char)s[i]] + 1;
        }

        lastIndex[(unsigned char)s[i]] = i;

        int currentLen = i - start + 1;
        if (currentLen > maxLen)
            maxLen = currentLen;
    }

    return maxLen;
}
