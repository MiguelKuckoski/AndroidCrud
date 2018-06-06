package com.example.androidcrud;

import java.util.ArrayList;

import com.example.androidcrud.crud.CreateDB;
import com.example.androidcrud.crud.DeleteDB;
import com.example.androidcrud.crud.InsertOrUpdateDB;
import com.example.androidcrud.crud.ReadDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
	Button btnAddPessoa, btnRemoverPessoa, btnRegistros, btnRemoverTabela, btnEditarPessoa;
	EditText etNome, etIdade;
	Switch sCasada;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnAddPessoa = (Button) findViewById(R.id.btnAddPessoa);
		btnRemoverPessoa = (Button) findViewById(R.id.btnRemoverPessoa);
		btnRegistros = (Button) findViewById(R.id.btnRegistro);
		btnEditarPessoa = (Button) findViewById(R.id.btnEditarPessoa);
		btnRemoverTabela = (Button) findViewById(R.id.btnTabela);

		etNome = (EditText) findViewById(R.id.etNome);
		etIdade = (EditText) findViewById(R.id.etIdade);

		sCasada = (Switch) findViewById(R.id.switchCasada);

		btnAddPessoa.setOnClickListener(this);
		btnRemoverPessoa.setOnClickListener(this);
		btnRegistros.setOnClickListener(this);
		btnRemoverTabela.setOnClickListener(this);
		btnEditarPessoa.setOnClickListener(this);
		CreateDB create = new CreateDB(getApplicationContext());
		create.createTable();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnAddPessoa) {
			Pessoa p = new Pessoa();
			p.setNome(etNome.getText().toString());
			p.setIdade(Integer.parseInt(etIdade.getText().toString()));
			p.setCasada(sCasada.isChecked());

			InsertOrUpdateDB u = new InsertOrUpdateDB(getApplicationContext());
			String msg = "";
			if (u.insertPessoa(p)) {
				msg = "Cadastro inserido com sucesso.";
			} else {
				msg = "Erro no cadastro.";
			}

			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

		} else if (view.getId() == R.id.btnEditarPessoa) {
			Pessoa p = new Pessoa();
			p.setNome(etNome.getText().toString());
			p.setIdade(Integer.parseInt(etIdade.getText().toString()));
			p.setCasada(sCasada.isChecked());

			InsertOrUpdateDB u = new InsertOrUpdateDB(getApplicationContext());
			String msg = "";
			if (u.updatePessoa(p)) {
				msg = "Cadastro atualizado com sucesso.";
			} else {
				msg = "Erro na atualização.";
			}
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

		} else if (view.getId() == R.id.btnRemoverPessoa) {
			Pessoa p = new Pessoa();
			p.setNome(etNome.getText().toString());
			p.setIdade(Integer.parseInt(etIdade.getText().toString()));
			p.setCasada(sCasada.isChecked());

			DeleteDB del = new DeleteDB(getApplicationContext());
			
			String msg = "";
			if (del.deletePessoa(p)) {
				msg = "Cadastro removido com sucesso.";
			} else {
				msg = "Erro na remoção.";
			}
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
			
		} else if (view.getId() == R.id.btnRegistro) {
			ReadDB read = new ReadDB(getApplicationContext());
			ArrayList<Pessoa> pArray = new ArrayList<Pessoa>();
			pArray.clear();
			pArray = read.getPessoas();
			Intent intent = new Intent(this, ListaRegistro.class);
			intent.putExtra("pArray", pArray);
			startActivity(intent);
			
		} else if (view.getId() == R.id.btnTabela) {
			
			DeleteDB del = new DeleteDB(getApplicationContext());
			String msg = "";
			if(del.deleteTable()) {
				msg = "Tabela removida.";
			}else{
				msg = "Erro na remoção.";
			};
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();			
		}
	}
}
