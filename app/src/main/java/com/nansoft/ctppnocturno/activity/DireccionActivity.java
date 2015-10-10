package com.nansoft.ctppnocturno.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nansoft.ctppnocturno.R;


public class DireccionActivity extends ActionBarActivity implements OnClickListener
{
	
	TextView TituloDireccion;
	TextView Direccion;
	String nombrePref = "Preferencias";
	String TAMFUENTETITULO = "tamtitulo";
	String TAMFUENTESUBTITULO = "tamsubtitulo";
	String TAMFUENTEINFO = "taminfo";
	SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laydireccion);
		
		TituloDireccion = (TextView) findViewById(R.id.titulodireccion);
		Direccion = (TextView) findViewById(R.id.infodireccion);
		
		
		ImageButton BotonMapa = (ImageButton) findViewById(R.id.btnMapa);
		BotonMapa.setOnClickListener(this);

	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
		
		TituloDireccion.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
		Direccion.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));
		
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
    
    @Override
    public void onClick(View vista)
    {
    	if (vista.getId() == R.id.btnMapa)
    	{   // cambiar por mapa!!

            try
            {
                String url = "waze://?ll=9.844285,-84.318397&navigate=yes";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity( intent );
            }
            catch ( ActivityNotFoundException ex  )
            {
                Intent intent =
                        new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
                startActivity(intent);
            }
    	}
    }
    
	

}
