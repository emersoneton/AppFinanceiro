package com.example.financeiro.database;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.financeiro.mensagem.CxMsg;

public class LoginDAO {
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

    public static void Logar(Activity activity, String nome, String senha){

        cursor = BuscarDados(activity);

        String nomeUsuario, senhaUsuario;

        for(int x=0; x < cursor.getCount(); x++){
           // msg.Mensagem("Nome: "+cursor.getString(cursor.getColumnIndex("nome"))+ "Senha: "+cursor.getString(cursor.getColumnIndex("senha")),activity);

            try {
                cursor.moveToNext();

                nomeUsuario = cursor.getString(cursor.getColumnIndex("nome"));
                senhaUsuario = cursor.getString(cursor.getColumnIndex("senha"));

                if(nome.equals(nomeUsuario) & senha.equals(senhaUsuario)){
                    msg.Mensagem("Login OK", activity);
                }

            }catch (Exception ex){
                Log.v("BancodeDados", "Erro ao buscar Usuario e Senha no Login!");
            }
        }

    }

    private static Cursor BuscarDados(Activity activity){
        AbrirBanco(activity);
        cursor=db.query( "usuario",
                new String[]{"nome","senha"},
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst(); //move para o primeiro registro
        return cursor;
    }
}
