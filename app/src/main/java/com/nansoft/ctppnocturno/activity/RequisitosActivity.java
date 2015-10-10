package com.nansoft.ctppnocturno.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nansoft.ctppnocturno.R;

public class RequisitosActivity extends ActionBarActivity
{
	// http://happycodetricks.wordpress.com/2013/09/23/codigo-colocar-un-borde-a-un-linearlayout-en-android/
	String nombrePref = "Preferencias";
	String TAMFUENTETITULO = "tamtitulo";
	String TAMFUENTESUBTITULO = "tamsubtitulo";
	String TAMFUENTEINFO = "taminfo";
	
	TextView Requisitos;
	TextView InfoRequisitos;
	
	SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layrequisitos);
		Requisitos = (TextView) findViewById(R.id.txtvTiRequi);
		InfoRequisitos = (TextView) findViewById(R.id.txtvInfoRequi);
		
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
		
		Requisitos.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
		InfoRequisitos.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));
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
				super.onDestroy();
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
