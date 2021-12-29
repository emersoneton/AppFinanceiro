package com.example.financeiro.database;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContextWrapper;
import android.util.Log;

import com.example.financeiro.mensagem.CxMsg;

public class UsuarioDAO {

    static SQLiteDatabase db=null;
    static Cursor cursor;

    static CxMsg msg;

    public static void AbrirBanco(Activity activity){

        try { // Criar o BD se caso não existir ou abrir caso existir
            ContextWrapper cw=new ContextWrapper(activity);
            db=cw.openOrCreateDatabase("FINANCEIRO", MODE_PRIVATE, null);
        }catch (Exception ex){
            msg.Mensagem("Erro ao abrir o BD: "+ex, activity);
        }finally {
            Log.v("BancodeDados", "Banco ABERTO com sucesso!");
        }
    }

    public static void FecharDB(){
        db.close();
        Log.v("BancodeDados", "Banco de Dados (FECHADO)!");
    }

    public static void AbrirTabelaUsuario(Activity activity){
        AbrirBanco(activity);
        try { // Criar Tabela Usuario
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY, nome TEXT, email TEXT, senha TEXT);");
            Log.v("BancodeDados", "Tabela usuario CRIADA com sucesso!");
        }catch (Exception ex){
            msg.Mensagem("Erro ao criar a Tabela Contatos: "+ex,activity);
        }

    }

    public static boolean InserirRegistroUsuario(Activity activity, String nome, String email, String senha){
        AbrirTabelaUsuario(activity);

        try {
            db.execSQL("INSERT INTO usuario (nome, email, senha) VALUES ('"+nome+"', '"+email+"', '"+senha+"');");
            msg.Mensagem("Usuário Cadastrado com Sucesso!",activity);
            return true;
        }catch (Exception ex){
            msg.Mensagem("Erro ao inserir Registro: "+ex,activity);
            Log.v("BancodeDados", "Erro ao inserir dados no BD: "+ex);
        }

        FecharDB();
        return false;
    }

}
