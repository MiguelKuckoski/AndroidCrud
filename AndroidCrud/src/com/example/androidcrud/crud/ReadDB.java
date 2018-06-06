package com.example.androidcrud.crud;

import java.util.ArrayList;

import com.example.androidcrud.Pessoa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReadDB extends SQLiteOpenHelper{
	
	private static final String NOME_DB = "MEU_DB";
	private static final int VERSAO_DB = 1;
	private static final String TABELA_PESSOA = "TABELA_PESSOA";
	private static final String PATH_DB = "/data/user/0/com.example.androidcrud.crud/databases/MEU_DB";
	
	private Context mContext;
	private SQLiteDatabase db;
			
	public ReadDB(Context context) {
		super(context, NOME_DB, null, VERSAO_DB);
		this.mContext = context;
		db = getReadableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Logica para atualizar o DB
		
	}

	public ArrayList<Pessoa> getPessoas() {
		openDB();
		ArrayList<Pessoa> pArray = new ArrayList<Pessoa>();
		String query = "SELECT * FROM " + TABELA_PESSOA;
		
		try {
			Cursor c = db.rawQuery(query, null);
			if(c.moveToFirst()) {
				do {
					Pessoa p = new Pessoa();
					p.setNome(c.getString(0));
					p.setIdade(c.getInt(1));
					p.setCasada(Boolean.parseBoolean(c.getString(2)));
					pArray.add(p);
				} while (c.moveToNext());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			db.close();
		}
		
		return pArray;
	}
	
	private void openDB() {
		if(!db.isOpen()) {
			db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
		}
	}
}
