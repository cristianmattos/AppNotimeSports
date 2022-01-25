package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.N;

public class ActivityTelaProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        ListView itensLista = (ListView) findViewById(R.id.itensLista);
        ArrayAdapter adapter = new ItensAdapter(this, adicionarItens());
        itensLista.setAdapter(adapter);

    }

    private ArrayList<Itens> adicionarItens() {
        ArrayList<Itens> itens = new ArrayList<Itens>();
        Itens e = new Itens("Tenis nike", "1499 S/N", R.drawable.adidasverde);


        e = new Itens("ADIDAS - Chuteira X 19 Blue Campo ",
                "R$208,99", R.drawable.adidasblue);
        itens.add(e);
        e = new Itens("ADIDAS - Chuteira Nemeziz 19.3",
                "R$311,99", R.drawable.adidasrosa);
        itens.add(e);

        e = new Itens("ADIDAS - Bola ucl finale istanbul society",
                "R$109,00", R.drawable.adidasbola);
        itens.add(e);

        e = new Itens("ADIDAS - Bola De Basquete 3 Stripes",
                "R$108,00", R.drawable.adidasbolabasq);
        itens.add(e);

        e = new Itens("ELEMENT - Skate preto ect01 8.5 ",
                "R$279,90", R.drawable.skatepreto);
        itens.add(e);

        e = new Itens("ELEMENT - Skate stay puft 8.5 ",
                "R$279,90", R.drawable.skatebranco);
        itens.add(e);

        e = new Itens("ELEMENT - Skate bergy tyson 8.5 ",
                "R$259,90", R.drawable.skateamarelo);
        itens.add(e);

        e = new Itens("ELEMENT - BONÉ KNUSTEN",
                "R$99,90", R.drawable.bonepreto);
        itens.add(e);

        e = new Itens("EVERLAST - Luva de Boxe e Muay Thai Power",
                "R$329,90", R.drawable.everlastpreta);
        itens.add(e);

        e = new Itens("EVERLAST - Camiseta Fundamentals",
                "R$69,99", R.drawable.everlastbranca);
        itens.add(e);

        e = new Itens("EVERLAST - Shorts De Muay Thai",
                "R$59,99", R.drawable.everlastazul);
        itens.add(e);

        e = new Itens("EVERLAST - Saco de Pancada Polycanvas 30Kg",
                "R$328,90", R.drawable.everlastsaco);
        itens.add(e);

        e = new Itens("NIKE - Camisa new brady futebol americano",
                "R$279,99", R.drawable.nikebranco);
        itens.add(e);

        e = new Itens("NIKE -Camisa NFL Kansas futebol americano",
                "R$274,99", R.drawable.nikevermelho);
        itens.add(e);

        e = new Itens("NIKE - Camisa Jordan X PSG IV",
                "R$274,99", R.drawable.nikeazulada);
        itens.add(e);

        e = new Itens("NIKE - Bola de futebol de campo Pitch",
                "R$59,99", R.drawable.nikeamarelo);
        itens.add(e);

        e = new Itens("VENUM - Camiseta",
                "R$59,69", R.drawable.venumcamisa);
        itens.add(e);

        e = new Itens("VENUM - Attack luvas MMA black",
                "R$369,69", R.drawable.venumpreta);
        itens.add(e);

        e = new Itens("VENUM - Attack luvas MMA white",
                "R$369,69", R.drawable.venumbranca);
        itens.add(e);

        e = new Itens("VENUM - Caneleira Kontact",
                "R$289,99", R.drawable.venumcaneleira);
        itens.add(e);


        return itens;
    }
}

