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
    }
}
