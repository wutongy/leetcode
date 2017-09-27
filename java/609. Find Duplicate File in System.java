// O(n)
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (String s : paths) {
            String[] sp1 = s.split(" ");
            for (int i = 1; i < sp1.length; ++i) {
                String[] sp2 = sp1[i].split("\\(");
                String fileContent = sp2[1].substring(0, sp2[1].length() - 1);
                if (!map.containsKey(fileContent)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(sp1[0] + "/" + sp2[0]);
                    map.put(fileContent, list);
                } else {
                    map.get(fileContent).add(sp1[0] + "/" + sp2[0]);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
