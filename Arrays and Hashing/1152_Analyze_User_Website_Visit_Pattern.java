import java.util.*;

public class Solution {
    class Visit {
        String user;
        int time;
        String site;
        Visit(String u, int t, String s) {
            user = u;
            time = t;
            site = s;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }

        visits.sort((a, b) -> a.time - b.time);

        Map<String, List<String>> userToSites = new HashMap<>();
        for (Visit v : visits) {
            if (!userToSites.containsKey(v.user)) {
                userToSites.put(v.user, new ArrayList<>());
            }
            userToSites.get(v.user).add(v.site);
        }

        Map<String, Set<String>> patternToUsers = new HashMap<>();
        for (String user : userToSites.keySet()) {
            List<String> sites = userToSites.get(user);
            if (sites.size() < 3) continue;

            Set<String> seen = new HashSet<>();
            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        if (seen.add(pattern)) {
                            if (!patternToUsers.containsKey(pattern)) {
                                patternToUsers.put(pattern, new HashSet<>());
                            }
                            patternToUsers.get(pattern).add(user);
                        }
                    }
                }
            }
        }

        String result = "";
        int maxCount = 0;
        for (String pattern : patternToUsers.keySet()) {
            int count = patternToUsers.get(pattern).size();
            if (count > maxCount || (count == maxCount && pattern.compareTo(result) < 0)) {
                maxCount = count;
                result = pattern;
            }
        }

        return Arrays.asList(result.split(","));
    }
}
