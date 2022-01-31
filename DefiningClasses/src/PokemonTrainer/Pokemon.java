package PokemonTrainer;

public class Pokemon {
    private String pokemonName;
    private String element;
    private int health;

    public String getPokemonName() {
        return pokemonName;
    }

    public String getElement() {
        return element;
    }

    public void setHealth(int health) {
        this.health = this.health - health;
    }

    public int getHealth() {
        return health;
    }

    public Pokemon(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }
}
