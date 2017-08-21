// O(nk)
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            arr[rowIndex - i] = 1;
            for (int j = rowIndex - i + 2; j <= rowIndex; j++) {
                arr[j - 1] += arr[j];
            }
        }
        return Arrays.asList(arr);
    }
}
