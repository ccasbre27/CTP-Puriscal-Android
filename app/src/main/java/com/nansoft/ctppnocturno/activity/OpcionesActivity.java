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
import com.nansoft.ctppnocturno.adapter.AdaptadorOpciones;
import com.nansoft.ctppnocturno.model.Opcion;

public class OpcionesActivity extends ActionBarActivity implements OnItemClickListener
{
	private ListView ListaItems;
	private ArrayList <Opcion> ArrayOpciones;
	private AdaptadorOpciones Adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		ArrayOpciones = new ArrayList <Opcion> ();
		LlenarArray();
		Adaptador = new AdaptadorOpciones (this,ArrayOpciones);
		ListaItems = (ListView) findViewById(R.id.lvCarreras);
		ListaItems.setAdapter(Adaptador);
		ListaItems.setOnItemClickListener(this);	
	}
	
	private void LlenarArray()
	{
		
		ArrayOpciones.add(new Opcion(0,"Técnicos Medios","",R.drawable.carreras));
        ArrayOpciones.add(new Opcion(1,"Horario","",R.drawable.horario));
        ArrayOpciones.add(new Opcion(2,"Beneficios","",R.drawable.benefits));
		ArrayOpciones.add(new Opcion(3,"Requisitos","",R.drawable.requisitos));
		ArrayOpciones.add(new Opcion(4,"Contacto","",R.drawable.contacto));
		ArrayOpciones.add(new Opcion(5,"Dirección","",R.drawable.localizacion));
		
	}
	
	@Override
	public void onItemClick(AdapterView <?> adapter, View view, int position, long ID)
	{
        Intent intent =  new Intent(this,OpcionesActivity.class);;
		switch (position)
		{
			case 0:
                intent = new Intent(this,TecnicosActivity.class);
				break;

            case 1:
                intent = new Intent(this,HorarioActivity.class);
                break;

            case 2:
                intent = new Intent (this,BenefitsActivity.class);
                break;
				
			case 3:
                intent = new Intent(this,RequisitosActivity.class);
				break;
				
			case 4:
                intent = new Intent (this,ContactoActivity.class);
				break;

            case 5:
                intent = new Intent (this,DireccionActivity.class);
                break;
		}

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
