package com.sethbarton.pokedex_java.server;

import android.util.Log;

import com.sethbarton.pokedex_java.models.Model;
import com.sethbarton.pokedex_java.util.Singleton;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ServerProxy {

    public interface PokemonService {
        @GET("pokemon")
        Call<Model> listPokemon();
    }

    public void getAllPokemon() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        Call<Model> call = service.listPokemon();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Model model = response.body();
                Singleton.setModelObject(model);
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                System.out.println("FAILED!");
            }

        });
    }

}
