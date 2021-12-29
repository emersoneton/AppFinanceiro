package com.example.financeiro.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.financeiro.R;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void PagamentoDevedor(View view){
        Intent intentPagamentoDevedor = new Intent(this, PagamentoDevedor.class);
        startActivity(intentPagamentoDevedor);
    }
}