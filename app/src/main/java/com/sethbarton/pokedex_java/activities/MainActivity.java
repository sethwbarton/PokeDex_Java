package com.sethbarton.pokedex_java.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sethbarton.pokedex_java.R;
import com.sethbarton.pokedex_java.server.ServerProxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServerProxy proxy = new ServerProxy();
        proxy.getAllPokemon();

    }
}
