package com.example.ecommerce;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;

import com.example.ecommerce.Interface.ItemClickListner;
import com.example.ecommerce.R;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creaza o noua instanta a ProductViewHolder utilizand layout-ul item-ului de produs
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        // Afiseaza informatiile despre produs pentru elementul la pozitia specificata
        Product product = productList.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView txtproductName, txtproductDescription, txtProductPrice;
        public ImageView imageView;
        public ItemClickListner listner;
        public ProductViewHolder(View itemview){
            super(itemview);

            imageView=(ImageView) itemview.findViewById(R.id.product_image);
            txtproductName=(TextView) itemview.findViewById(R.id.product_name);
            txtproductDescription=(TextView) itemview.findViewById(R.id.product_description);
            txtProductPrice=(TextView) itemview.findViewById(R.id.product_price);
        }
        public void bind(Product product) {
            // Setează informațiile despre produs în elementele de afișare
            Picasso.get().load(product.getImagine()).into(imageView);
            txtproductName.setText(product.getName());
            txtproductDescription.setText(product.getDescription());
            txtProductPrice.setText(product.getPrice());
        }
        public void setItemClickListner(ItemClickListner listner ){
            this.listner = listner;
        }
        @Override
        public void onClick(View view) {
            listner.onClick(view, getAdapterPosition(), false);
        }
    }
}