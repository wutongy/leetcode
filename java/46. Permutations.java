// recursive
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedHashSet<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Set<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.add(num)) {
                dfs(res, path, nums);
                path.remove(num);
            }
        }
    }
}

// iterative
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<Integer>());
        for (int n : nums) {
            int size = res.size();
            while (size > 0) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); ++i) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    res.add(t);
                }
                --size;
            }
        }
        return res;
    }
}

// use nextPermutation
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        List<Integer> next = new ArrayList<>();
        for (int n : nums) {
            next.add(n);
        }
        res.add(next);
        while ((next = nextPermutation(new ArrayList<>(next))) != null) {
            res.add(next);
        }
        return res;
    }

    private List<Integer> nextPermutation(List<Integer> nums) {
        int k = -1;
        for (int i = nums.size() - 2; i >= 0; --i) {
            if (nums.get(i) < nums.get(i + 1)) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return null;
        }
        int l = -1;
        for (int i = nums.size() - 1; i > k; --i) {
            if (nums.get(i) > nums.get(k)) {
                l = i;
                break;
            }
        }
        Integer temp = nums.get(k);
        nums.set(k, nums.get(l));
        nums.set(l, temp);
        int i = k + 1, j = nums.size() - 1;
        while (i < j) {
            temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            ++i;
            --j;
        }
        return nums;
    }
}
