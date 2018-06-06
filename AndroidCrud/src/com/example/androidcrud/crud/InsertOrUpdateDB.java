package com.example.androidcrud.crud;

import com.example.androidcrud.Pessoa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InsertOrUpdateDB extends SQLiteOpenHelper{
	
	private static final String NOME_DB = "MEU_DB";
	private static final int VERSAO_DB = 1;
	private static final String TABELA_PESSOA = "TABELA_PESSOA";
	private static final String PATH_DB = "/data/user/0/com.example.androidcrud.crud/databases/MEU_DB";
	
	private Context mContext;
	private SQLiteDatabase db;
			
	public InsertOrUpdateDB(Context context) {
		super(context, NOME_DB, null, VERSAO_DB);
		this.mContext = context;
		db = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Logica para atualizar o DB
		
	}	
	
	public boolean insertPessoa(Pessoa p) {
		openDB();
		
		try {
			ContentValues cv = new ContentValues();
			cv.put("NOME", p.getNome());
			cv.put("IDADE", p.getIdade());
			cv.put("CASADA", String.valueOf(p.isCasada()));
			
			db.insert(TABELA_PESSOA, null, cv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			db.close();
		}
	}
	
	public boolean updatePessoa(Pessoa p) {
		openDB();
		
		try {
			String where = "NOME = '" +p.getNome() +"'";
			ContentValues cv = new ContentValues();
			cv.put("NOME", p.getNome());
			cv.put("IDADE", p.getIdade());
			cv.put("CASADA", String.valueOf(p.isCasada()));
			
			db.update(TABELA_PESSOA, cv, where, null);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			db.close();
		}
	}
	
	private void openDB() {
		if(!db.isOpen()) {
			db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
		}
	}
}
