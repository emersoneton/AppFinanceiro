package com.example.financeiro.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.financeiro.R;
import com.example.financeiro.database.LoginDAO;
import com.example.financeiro.mensagem.CxMsg;

public class MainActivity extends AppCompatActivity {

    EditText etLogin, etSenha;

    CxMsg msg;

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

        Intent intentPrincipal = new Intent(this, TelaPrincipal.class);
        startActivity(intentPrincipal);
        /*
        if(LoginDAO.Logar(this,etLogin.getText().toString(),etSenha.getText().toString())){
            Intent intentPrincipal = new Intent(this, TelaPrincipal.class);
            startActivity(intentPrincipal);
        }else{
            msg.Mensagem("Usuario e Senha não conferem!", this);
        }
        */
    }
}