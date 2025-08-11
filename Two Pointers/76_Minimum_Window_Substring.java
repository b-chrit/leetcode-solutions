// Time: O(|s| + |t|), Space: O(1) - fixed 128-size array
// Logic: Sliding window - expand right until valid window found, then contract left 
// to find minimum while valid. Once window breaks, continue expanding to find next 
// valid window, giving every position opportunity to be optimal starting point.
