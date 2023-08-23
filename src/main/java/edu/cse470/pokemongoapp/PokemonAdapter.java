package edu.cse470.pokemongoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.cse470.pokemongoapp.inventory.Pokemon;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> pokemonList;

    public PokemonAdapter(Context context, List<Pokemon> pokmemonList) {
        this.context = context;
        this.pokemonList = pokmemonList;
    }

    @Override
    public int getCount() {
        return pokemonList != null ? pokemonList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        if(i == 0){
            return "Groudon";
        }
        if(i == 1){
            return "Kyogre";
        }
        if(i == 2){
            return "Rayquaza";
        }
        if(i == 3){
            return "Registeel";
        }
        if(i == 4){
            return "Regice";
        }
        if(i == 5){
            return "Regirock";
        }
        if(i == 6){
            return "Latios";
        }
        if(i == 7){
            return "Latias";
        }
        return "Error";
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_pokemon, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        ImageView image = rootView.findViewById(R.id.image);

        txtName.setText(pokemonList.get(i).getName());
        image.setImageResource(pokemonList.get(i).getImage());

        return rootView;
    }
}
