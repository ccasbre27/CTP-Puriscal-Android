package com.nansoft.ctppnocturno.adapter;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nansoft.ctppnocturno.HolderCarreras;
import com.nansoft.ctppnocturno.R;
import com.nansoft.ctppnocturno.model.Opcion;

public class AdaptadorCarreras extends ArrayAdapter <Opcion>
{
	private Context context;
	private ArrayList <Opcion> Datos;
	
	public AdaptadorCarreras(Context pContext,ArrayList <Opcion> pDatos)
	{
		super(pContext, R.layout.itemadapter, pDatos);
		context = pContext;
		Datos = pDatos;
	}
	
	@Override
	public View getView(int position, View convertView,ViewGroup parents)
	{
		HolderCarreras holder;
		View item = convertView;
		 
		if(item == null) 
		{
			item = LayoutInflater.from(context).inflate(R.layout.itemadapter,
			        null);
			 
			holder = new HolderCarreras();
			holder.Imagen = (ImageView) item.findViewById(R.id.imgCarrera);
			holder.Titulo = (TextView) item.findViewById(R.id.tvTitulo);
			holder.Subtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
			
			item.setTag(holder);
		}
		
		holder = (HolderCarreras) item.getTag();
		
		holder.Imagen.setImageResource(Datos.get(position).getImagen());
		holder.Titulo.setText(Datos.get(position).getTitulo());
		holder.Subtitulo.setText(Datos.get(position).getSubtitulo());
		
		return item;
	}
}
