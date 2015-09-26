package br.com.ceduphh.joaopaulo.pokedex;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PokedexActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Pokemon[] pokemons = {
            new Pokemon("Charizard", 7, Type.FIRE, Type.FLYING),
            new Pokemon("Blastoise", 9, Type.WATER, null),
            new Pokemon("Tentacruel", 73, Type.WATER, Type.POISON),
            new Pokemon("Magneton", 82, Type.ELECTRIC, Type.STEEL),
            new Pokemon("Ariados", 168, Type.BUG, Type.POISON),
            new Pokemon("Murkrow", 198, Type.DARK, Type.FLYING),
            new Pokemon("Magcargo", 219, Type.FIRE, Type.ROCK),
        };

        PokedexAdapter adapter = new PokedexAdapter(this, pokemons);
        setListAdapter(adapter);
    }

    private class PokedexAdapter extends ArrayAdapter<Pokemon> {

        private PokedexAdapter(Context context, Pokemon[] objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View inflatedView = layoutInflater.inflate(R.layout.pokemon_list_layout, null);

            ImageView imageView = (ImageView) inflatedView.findViewById(R.id.image);
            TextView numberTextView = (TextView) inflatedView.findViewById(R.id.number);
            TextView nameTextView = (TextView) inflatedView.findViewById(R.id.name);
            TextView primaryTypeTextView = (TextView) inflatedView.findViewById(R.id.primaryType);
            TextView secondaryTypeTextView = (TextView) inflatedView.findViewById(R.id.secondaryType);

            Pokemon pokemon = getItem(position);

            String formattedNumber = String.format("%03d", pokemon.getNationalNumber());

            nameTextView.setText(pokemon.getName());
            numberTextView.setText("(#" + formattedNumber + ")");

            int imageId = getResources().getIdentifier("sprite_" + formattedNumber, "drawable", getPackageName());
            imageView.setImageResource(imageId);

            configureForType(primaryTypeTextView, pokemon.getPrimaryType());
            configureForType(secondaryTypeTextView, pokemon.getSecondaryType());

            return inflatedView;
        }

        private void configureForType(TextView textView, Type type) {
            if (type == null) {
                textView.setVisibility(View.GONE);
            } else {
                int backgroundResource = getResources().getIdentifier("type_" + type.name().toLowerCase(), "drawable", getPackageName());
                int textResource = getResources().getIdentifier("type_" + type.name().toLowerCase(), "string", getPackageName());

                textView.setBackgroundResource(backgroundResource);
                textView.setText(textResource);
            }
        }
    }

}
