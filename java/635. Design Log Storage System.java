class LogSystem {
    TreeMap<String, Integer> map;
    public LogSystem() {
        map = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        map.put(timestamp, id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();

        String start = null;
        String end = null;
        if (gra.equals("Year")) {
            start = s.substring(0, 4) + ":00:00:00:00:00";
            end = e.substring(0, 4) + ":13:00:00:00:00"; //month is less than 13
        }
        else if (gra.equals("Month")) {
            start = s.substring(0, 7) + ":00:00:00:00";
            end = e.substring(0, 7) + ":32:00:00:00";//day is less than 31
        }
        else if (gra.equals("Day")) {
            start = s.substring(0, 10) + ":00:00:00";
            end = e.substring(0, 10) + ":24:00:00";//hour is less than 24
        }
        else if (gra.equals("Hour")) {
            start = s.substring(0, 13) + ":00:00";
            end = e.substring(0, 13) + ":60:00";//min is less than 60
        }
        else if (gra.equals("Minute")) {
            start = s.substring(0, 16) + ":00";
            end = e.substring(0, 16) + ":60";//second is less than 60
        }
        else {
            start = s;
            end = e + '1'; //increase range since the end is exclusive
        }
        Map<String, Integer> maps = map.subMap(start, end);
        for (int i : maps.values()) res.add(i);
        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
