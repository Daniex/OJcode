class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0) {
            return 0;
        }
        bool vis[256];
        memset(vis, false, sizeof(vis));
        int ans = 1, l = 0, r = 0;
        while (l <= r && r < s.length()) {
            while (r < s.length() && vis[ s[r] ] == false) {
                vis[ s[r++] ] = true;
            }
            ans = max(ans, r - l);
            while (l < r && s[l] != s[r]) {
                vis[ s[l++] ] = false;
            }
            l++, r++;
        }
        return ans;
    }
};
