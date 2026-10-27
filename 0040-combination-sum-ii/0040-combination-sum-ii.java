import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int[] candidates, int target, List<Integer> ans, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            if(i>start && candidates[i]==candidates[i - 1]) {
                continue;
            }
            if(candidates[i]> target) {
                break;
            }
            ans.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],ans,result);
            ans.remove(ans.size()-1);
        }
    }
}