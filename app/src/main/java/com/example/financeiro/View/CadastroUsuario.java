package com.example.financeiro.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.financeiro.R;
import com.example.financeiro.database.UsuarioDAO;
import com.example.financeiro.mensagem.CxMsg;

public class CadastroUsuario extends AppCompatActivity {

    EditText etNomeUsuario, etEmailUsuario, etSenhaUsuario, etRepitaSenhaUsuario;
    Button btnGravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        etNomeUsuario=(EditText) findViewById(R.id.etNomeUsuario);
        etEmailUsuario=(EditText) findViewById(R.id.etEmailUsuario);
        etSenhaUsuario=(EditText) findViewById(R.id.etSenhaUsuario);
        etRepitaSenhaUsuario=(EditText) findViewById(R.id.etRepitaSenhaUsuario);

        btnGravar=(Button) findViewById(R.id.btnGravarCadastroUsuario);
    }

    public void VoltarTelaLogin(View view){
        this.finish();
    }

    public void Gravar(View view){
        UsuarioDAO.AbrirTabelaUsuario(this);

        String nome, email, senha, repitaSenha;
        nome=etNomeUsuario.getText().toString();
        email=etEmailUsuario.getText().toString();
        senha=etSenhaUsuario.getText().toString();
        repitaSenha=etRepitaSenhaUsuario.getText().toString();

        if(ValidarCampos(nome,email,senha,repitaSenha)){

            if(CompararSenhas(senha, repitaSenha)){

                 if(UsuarioDAO.InserirRegistroUsuario(this, nome, email, senha)){
                     LimparCampos();
                 }

            }else{
                CxMsg.Mensagem("As senhas não conferem!", this);
            }

        }

    }

    private boolean CompararSenhas(String senha, String repitaSenha){

        if(senha.equals(repitaSenha)) {
            return true;
        }else{
            return false;
        }

    }

    private boolean ValidarCampos(String nome, String email, String senha, String repitaSenha){
        if(nome.equals("")){
            CxMsg.Mensagem("Deve ser informado o Usuário", this);
            return false;
        }
        if(email.equals("")){
            CxMsg.Mensagem("Deve ser informado o E-mail", this);
            return false;
        }
        if(senha.equals("")){
            CxMsg.Mensagem("Deve ser informada a Senha", this);
            return false;
        }
        if(repitaSenha.equals("")){
            CxMsg.Mensagem("Deve ser informado o repita a senha", this);
            return false;
        }
        return true;
    }

    private void LimparCampos(){
        etNomeUsuario.setText("");
        etEmailUsuario.setText("");
        etSenhaUsuario.setText("");
        etRepitaSenhaUsuario.setText("");
    }

}