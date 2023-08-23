package edu.cse470.pokemongoapp.inventory;

import java.util.ArrayList;
import java.util.List;

import edu.cse470.pokemongoapp.R;

public class Data {

    public static List<Pokemon> getPokemonList() {
        List<Pokemon> PokemonList = new ArrayList<>();

        Pokemon Groudon = new Pokemon();
        Groudon.setName("Groudon");
        Groudon.setImage(R.drawable.groudon);
        PokemonList.add(Groudon);

        Pokemon Kyogre = new Pokemon();
        Kyogre.setName("Kyogre");
        Kyogre.setImage(R.drawable.kyogre);
        PokemonList.add(Kyogre);

        Pokemon Rayquaza = new Pokemon();
        Rayquaza.setName("Rayquaza");
        Rayquaza.setImage(R.drawable.rayquaza);
        PokemonList.add(Rayquaza);

        Pokemon Registeel = new Pokemon();
        Registeel.setName("Registeel");
        Registeel.setImage(R.drawable.registeel);
        PokemonList.add(Registeel);

        Pokemon Regice = new Pokemon();
        Regice.setName("Regice");
        Regice.setImage(R.drawable.regice);
        PokemonList.add(Regice);

        Pokemon Regirock = new Pokemon();
        Regirock.setName("Regirock");
        Regirock.setImage(R.drawable.regirock);
        PokemonList.add(Regirock);

        Pokemon Latios = new Pokemon();
        Latios.setName("Latios");
        Latios.setImage(R.drawable.latios);
        PokemonList.add(Latios);

        Pokemon Latias = new Pokemon();
        Latias.setName("Latias");
        Latias.setImage(R.drawable.latias);
        PokemonList.add(Latias);

        return PokemonList;
    }

}