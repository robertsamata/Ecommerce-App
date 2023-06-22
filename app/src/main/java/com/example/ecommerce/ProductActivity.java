package com.example.ecommerce;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_items_layout);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initializeaza lista de produse
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("https://lcdn.altex.ro/media/catalog/product/i/p/iphone_14_pro_space_black-1_e51401e6.jpg", "Iphone 14 Pro", "iPhone 14 Pro.Surprinde detalii incredibile cu noua camera principala de 48MP. Bucura-te de experienta iPhone intr-un mod cu totul nou cu Dynamic Island si Always-On display. Crash Detection, o noua functionalitate de siguranta, solicita ajutor daca tu nu poti.", "800$"));
        productList.add(new Product("https://s13emagst.akamaized.net/products/4458/4457707/images/res_afd4e96b82dc5f99095028dc729e1e6d.jpg", "Beats by Dre", "Cu o durata de viata a bateriei de pana la 40 de ore, Beats Solo 3 Wireless sunt castile perfecte de zi cu zi. Cu o incarcare de 5 minute (Fast Fuel) - puteti asculta muzica timp de trei ore. Castile on-ear sunt reglabile, astfel acestea raman confortabile pe tot parcursul zilei.", "200$"));
        productList.add(new Product("https://lcdn.altex.ro/resize/media/catalog/product/C/A/2bd48d28d1c32adea0e55139a4e6434a/CASAIRPODS_313d0f7a.jpg", "Airpods 2", "Acum, cu mai mult timp de convorbire, accesul Siri activat prin voce, AirPods 2 ofera o experienta uimitoare pentru castile wireless. Le scoti din cutie si poti sa le folosesti. Se conecteaza instantaneu cand le pui la ureche. Ca prin magie.", "170$"));

        // Initializeaza adapterul cu lista de produse
        productAdapter = new ProductAdapter(productList);

        // Seteaza adapterul pentru RecyclerView
        recyclerView.setAdapter(productAdapter);
    }
}