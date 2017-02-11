package com.example.brand.ilovezappos;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brand.ilovezappos.databinding.ActivitySearchBinding;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity{

    private Connector connector;
    private Product product;
    private Bus bus;
    private Button addCart;
    private List<Product> cart;
    private TextView cartText;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        connector = new Connector();
        addCart = (Button)findViewById(R.id.addCart);
        addCart.setVisibility(View.INVISIBLE);
        cart = new ArrayList<>();

        animation = AnimationUtils.loadAnimation(this, R.anim.animations);
    }

    public void onSearchClick(View v){

        if(v.getId() == R.id.searchButton){
            EditText editText = (EditText)findViewById(R.id.searchEdit);
            String term = editText.getText().toString();
            connector.getSearchInfo(term);
        }

    }

    public void onCartClick(View v){

        if(v.getId() == R.id.addCart && product != null){
            v.startAnimation(animation);
            cart.add(product);
            cartText = (TextView)findViewById(R.id.cart);
            cartText.setText("Cart(" + cart.size() + ")");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void onProductsResponse(ProductsResponse productsResponse){
        if(productsResponse.getProducts().getResults().size() != 0){
            product = productsResponse.getProducts().getResults().get(0);
            ActivitySearchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
            binding.setProduct(product);
            addCart.setVisibility(View.VISIBLE);
            cartText = (TextView)findViewById(R.id.cart);
            cartText.setText("Cart(" + cart.size() + ")");
        }
        else{
            product = null;
            TextView message = (TextView)findViewById(R.id.brandName);
            TextView productName = (TextView)findViewById(R.id.productName);
            TextView price = (TextView)findViewById(R.id.price);
            ImageView imageView = (ImageView)findViewById(R.id.image);
            imageView.setImageResource(R.color.white);
            message.setText("No Items Found!");
            productName.setText("");
            price.setText("");
        }
    }
}
