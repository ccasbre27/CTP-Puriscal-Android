package com.nansoft.ctppnocturno.activity;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.nansoft.ctppnocturno.R;
import com.nansoft.ctppnocturno.adapter.AdaptadorCarreras;
import com.nansoft.ctppnocturno.model.Opcion;

public class TecnicosActivity extends ActionBarActivity implements OnItemClickListener
{
	private ListView ListaItems;
	private ArrayList <Opcion> ArrayItem;
	private AdaptadorCarreras Adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		ArrayItem = new ArrayList <Opcion> ();
		LlenarArray();
		Adaptador = new AdaptadorCarreras (this,ArrayItem);
		ListaItems = (ListView) findViewById(R.id.lvCarreras);
		ListaItems.setAdapter(Adaptador);
		ListaItems.setOnItemClickListener(this);	
	}
	
	private void LlenarArray()
	{
		ArrayItem.add(new Opcion(0,"Banca en Finanzas","Técnico",R.drawable.bancaenfinanzas));
		ArrayItem.add(new Opcion(1,"Contabilidad","Técnico",R.drawable.contador));
		ArrayItem.add(new Opcion(2,"Ejecutivo para Centro de Servicios","Técnico",R.drawable.customerservice));
		ArrayItem.add(new Opcion(3,"Informática Empresarial","Técnico",R.drawable.informaticamepresarial));
		ArrayItem.add(new Opcion(4,"Informática en Redes","Técnico",R.drawable.redes));
		ArrayItem.add(new Opcion(5,"Informática en Soporte","Técnico",R.drawable.soportecomputadoras));
		ArrayItem.add(new Opcion(6,"Logística y Distribución","Técnico",R.drawable.logistica));
		ArrayItem.add(new Opcion(7,"Secretariado Ejecutivo","Técnico",R.drawable.secretariado));
        ArrayItem.add(new Opcion(8,"Turismo de alimentos y bebidas","Técnico",R.drawable.turismo));
		
	}
	
	@Override
	public void onItemClick(AdapterView <?> adapter, View view, int position, long ID)
	{

	    Intent intent = new Intent(this,InfoTecnicoActivity.class);
        intent.putExtra("idTecnico",ArrayItem.get(position).getId());
		startActivity(intent);

	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected (MenuItem item) 
	{
		switch (item.getItemId())
		{
		
			case R.id.llamada:
				LlamarOpcion();
				break;
				
			case R.id.configurar:
				Intent AbrirConfiguraciones = new Intent(this,ConfiguracionesActivity.class);
				startActivity(AbrirConfiguraciones);
				break;
			
		}
		
		return false;
	} 
	
        
    public void LlamarOpcion()
    {
    	try {
	    	Intent Llamada = new Intent(Intent.ACTION_CALL);
	    	Llamada.setData(Uri.parse("tel:24168444"));
	    	startActivity(Llamada);
    	} catch (ActivityNotFoundException activityException) {
    		
    	}
    }
    

}
