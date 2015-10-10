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
import android.widget.Toast;

import com.nansoft.ctppnocturno.R;


public class ContactoActivity extends ActionBarActivity implements OnClickListener
{
	String nombrePref = "Preferencias";
	String TAMFUENTETITULO = "tamtitulo";
	String TAMFUENTESUBTITULO = "tamsubtitulo";
	String TAMFUENTEINFO = "taminfo";
	
	SharedPreferences prefs;
	
	TextView NumTelefono;
	TextView Correo;
	TextView TiTelefono;
	TextView TiCorreo;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laycontacto);
		
		TiTelefono = (TextView) findViewById(R.id.titelefono);
		NumTelefono = (TextView) findViewById(R.id.infotelefono);
		TiCorreo = (TextView) findViewById(R.id.ticorreo);
		Correo = (TextView) findViewById(R.id.infocorreo);
		
		
		ImageButton BotonLlamada = (ImageButton) findViewById(R.id.imagenllamada);
		BotonLlamada.setOnClickListener(this);
		
		ImageButton BotonCorreo = (ImageButton) findViewById(R.id.imagencorreo);
		BotonCorreo.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View vista)
	{
			switch (vista.getId())
			{
				case R.id.imagenllamada:
                    LlamarOpcion();
					break;
				
				case R.id.imagencorreo:
					String [] Correo = {"tecnicanocturnapuriscal@gmail.com"};
					AbrirCorreo(Correo);
					break;
			}
	}

	
    public void AbrirCorreo(String [] pPara)
    {
    	try {
	    	Intent Correo = new Intent(Intent.ACTION_SEND);
	    	Correo.setData(Uri.parse("mailto:"));
	    	Correo.putExtra(Intent.EXTRA_EMAIL,pPara);
	    	Correo.putExtra(Intent.EXTRA_CC, "");
	    	Correo.putExtra(Intent.EXTRA_SUBJECT, "");
	    	Correo.putExtra(Intent.EXTRA_TEXT, "");
	    	Correo.setType("message/rfc822");
	        startActivity(Intent.createChooser(Correo, "Email "));
	    } catch (ActivityNotFoundException activityException) {
			
	    	Toast.makeText(getBaseContext(), "Error verifique que tenga una aplicación de correo", Toast.LENGTH_SHORT).show();
	    	
		}
    }
    
	@Override
	protected void onResume()
	{
		super.onResume();
		prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
		
		TiTelefono.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
		NumTelefono.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));
		TiCorreo.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
		Correo.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));
		
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
