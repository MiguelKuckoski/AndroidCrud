package com.example.androidcrud;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

public class AdapterPessoa extends ArrayAdapter<Pessoa> {

	private Activity context;
	private ArrayList<Pessoa> pArray;
	private static LayoutInflater inflater = null;

	public AdapterPessoa(Activity context, ArrayList<Pessoa> pArray) {
		super(context, R.layout.lista_registro_item, pArray);
		this.context = context;
		this.pArray = pArray;

	}

	@Override
	public int getCount() {
		return pArray.size();
	}

	@Override
	public Pessoa getItem(int position) {
		return pArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.lista_registro_item, null);
		}

		TextView textName = (TextView) convertView.findViewById(R.id.tvNome);
		TextView textIdade = (TextView) convertView.findViewById(R.id.tvIdade);
		Switch sCasado = (Switch) convertView.findViewById(R.id.sCasado);

		Pessoa selectedPessoa = pArray.get(position);
		textName.setText(selectedPessoa.getNome());
		textIdade.setText(String.valueOf(selectedPessoa.getIdade()));
		sCasado.setChecked(selectedPessoa.isCasada());

		return convertView;
	}

}
