package PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;


    public Trainer(String name,int badges) {
        this.name = name;
        this.badges = badges;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }


}
