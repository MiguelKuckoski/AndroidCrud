package com.example.androidcrud;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ListaRegistro extends Activity{

	Button btnVoltar;
	ListView lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_registro);
		
		ArrayList<Pessoa> pArray = (ArrayList<Pessoa>) getIntent().getSerializableExtra("pArray");
		
		AdapterPessoa adapter = new AdapterPessoa(this, pArray);
		lista = (ListView) findViewById(R.id.listViewRegistro);
		lista.setAdapter(adapter);			
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
