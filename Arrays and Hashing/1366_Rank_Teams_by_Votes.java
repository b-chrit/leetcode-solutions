class Solution {
    class Team {
        char name;
        int[] votes;
        
        Team(char name, int positions) {
            this.name = name;
            this.votes = new int[positions];
        }
    }
    
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) {
            return "";
        }
        
        int n = votes[0].length();
        Map<Character, Team> teamMap = new HashMap<>();
        
        for (String vote : votes) {
            for (char teamName : vote.toCharArray()) {
                teamMap.putIfAbsent(teamName, new Team(teamName, n));
            }
        }
        
        for (String vote : votes) {
            for (int pos = 0; pos < vote.length(); pos++) {
                char teamName = vote.charAt(pos);
                teamMap.get(teamName).votes[pos]++;
            }
        }
        
        List<Team> teams = new ArrayList<>(teamMap.values());
        
        teams.sort((a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a.votes[i] != b.votes[i]) {
                    return b.votes[i] - a.votes[i];
                }
            }
            return Character.compare(a.name, b.name);
        });
        
        StringBuilder result = new StringBuilder();
        for (Team team : teams) {
            result.append(team.name);
        }
        
        return result.toString();
    }
}
