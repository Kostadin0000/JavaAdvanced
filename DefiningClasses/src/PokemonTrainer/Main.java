package PokemonTrainer;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<Pokemon>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            int badges = 0;
            List<Pokemon> list = new ArrayList<>();
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            list.add(pokemon);
            if (map.containsKey(name)) {
                map.get(name).add(pokemon);
            } else {
                map.put(name, list);
            }
            map2.put(name, 0);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();


        while (!input.equals("End")) {

            boolean isTrue = false;

            if (input.equals("Fire")) {
                for (Map.Entry<String, List<Pokemon>> entry : map.entrySet()) {
                    isTrue = false;
                    for (int i = 0; i < entry.getValue().size(); i++) {

                        if (entry.getValue().get(i).getElement().equals("Fire")) {
                            map2.put(entry.getKey(), map2.get(entry.getKey()) + 1);
                            isTrue = true;
                            break;
                        }
                    }
                    if (!isTrue) {
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            entry.getValue().get(i).setHealth(10);
                            if (entry.getValue().get(i).getHealth() <= 0) {
                                entry.getValue().remove(i);
                                i--;
                            }
                        }
                    }
                }

            } else if (input.equals("Electricity")) {
                for (Map.Entry<String, List<Pokemon>> entry : map.entrySet()) {
                    isTrue = false;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).getElement().equals("Electricity")) {
                            map2.put(entry.getKey(), map2.get(entry.getKey()) + 1);
                            isTrue = true;
                            break;
                        }
                    }
                    if (!isTrue) {
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            entry.getValue().get(i).setHealth(10);
                            if (entry.getValue().get(i).getHealth() <= 0) {
                                entry.getValue().remove(i);
                                i--;
                            }
                        }
                    }
                }

            } else if (input.equals("Water")) {
                for (Map.Entry<String, List<Pokemon>> entry : map.entrySet()) {
                    isTrue = false;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).getElement().equals("Water")) {
                            map2.put(entry.getKey(), map2.get(entry.getKey()) + 1);
                            isTrue = true;
                            break;
                        }
                    }
                    if (!isTrue) {
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            entry.getValue().get(i).setHealth(10);
                            if (entry.getValue().get(i).getHealth() <= 0) {
                                entry.getValue().remove(i);
                                i--;
                            }
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
        map2.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue(), b1.getValue()))
                .forEach(t -> {
                    System.out.println(String.format("%s %d %d", t.getKey(),
                            t.getValue(),
                            map.get(t.getKey()).size()));
                });
    }

}

