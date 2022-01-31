package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    //1 компания
    //1 кола
    //много родители, деца и покемони
    private Company company;
    private Car car;

    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Company:").append("\n");
        if(company != null) {
            builder.append(company.toString()).append("\n");
        }

        builder.append("Car:").append("\n");
        if(car != null) {
            builder.append(car.toString()).append("\n");
        }


        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons ) {
            builder.append(pokemon.toString()).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent.toString()).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child.toString()).append("\n");
        }

        return builder.toString();
    }
}
