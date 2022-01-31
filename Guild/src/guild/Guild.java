package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();

    }

    public void addPlayer(Player player) {
        if (this.roster.size() < capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;

    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        List<Player> players1 = new ArrayList<>();

        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getClazz().equals(clazz)){
                players1.add(this.roster.get(i));
                this.roster.remove(i);
                i--;

            }
        }
        Player[] players = new Player[players1.size()];
        for (int i = 0; i < players1.size(); i++) {
            players[i] = players1.get(i);
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }
    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Players in the guild: %s:",this.name)).append(System.lineSeparator());
        for (Player player : roster) {
            stringBuilder.append(player).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
//•	Method count() - returns the number of players