package com.example.financeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.financeiro.database.LoginDAO;
import com.example.financeiro.mensagem.CxMsg;

public class MainActivity extends AppCompatActivity {

    EditText etLogin, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin=(EditText) findViewById(R.id.etUsuarioLogin);
        etSenha=(EditText) findViewById(R.id.etSenhaLogin);
    }

    public void Cadastro(View view){
        Intent intentCadastro = new Intent(this, CadastroUsuario.class);
        startActivity(intentCadastro);
    }

    public void Logar(View view){

      //  CxMsg.Mensagem("Login: "+etLogin.getText().toString(), this);

        LoginDAO.Logar(this,etLogin.getText().toString(),etSenha.getText().toString());

    }
}