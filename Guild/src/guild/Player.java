package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";

    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Player %s: %s",getName(),getClazz())).append(System.lineSeparator());
        stringBuilder.append(String.format("Rank: %s",this.rank)).append(System.lineSeparator());
        stringBuilder.append(String.format("Description: %s",this.description));
        return stringBuilder.toString();
    }
}
