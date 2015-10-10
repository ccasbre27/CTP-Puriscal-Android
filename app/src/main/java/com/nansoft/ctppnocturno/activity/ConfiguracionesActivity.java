package com.nansoft.ctppnocturno.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.nansoft.ctppnocturno.R;

public class ConfiguracionesActivity extends ActionBarActivity implements OnClickListener
{
	
	private SharedPreferences prefs;
	private String nombrePref = "Preferencias";
	private TextView textoTitulo;
	TextView TextoSubtitulo ;
	TextView TextoInfo ;
	private SeekBar seekBar;
	private ImageView btn;
    ImageView btnEliminar;
	private static final String TAMFUENTETITULO = "tamtitulo";
	private static final String TAMFUENTESUBTITULO = "tamsubtitulo";
	private static final String TAMFUENTEINFO = "taminfo";
	private static final String PROGRESOBARRA = "progreso";
	int Tamanio = 0;
	

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuraciones);
		
		
		textoTitulo = (TextView) findViewById(R.id.muestratitulo);
		seekBar = (SeekBar) findViewById(R.id.barrafuente);
		btn = (ImageView) findViewById(R.id.btnSalvar);
		btnEliminar = (ImageView) findViewById(R.id.btnBorrar);
		TextoSubtitulo = (TextView) findViewById(R.id.muestrasubtitulo);
		TextoInfo = (TextView) findViewById(R.id.muestrainfo);
		
		btn.setOnClickListener(this);
		btnEliminar.setOnClickListener(this);
		
		
		
		SharedPreferences prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
		
		int TamanioTitulo = prefs.getInt(TAMFUENTETITULO, 19);
		
		int TamnioSubtitulo = prefs.getInt(TAMFUENTESUBTITULO, 17);
		
		int TamanioInfo = prefs.getInt(TAMFUENTEINFO, 15);
		
		Tamanio = prefs.getInt(PROGRESOBARRA, 19);
		
		seekBar.setMax(45);	
		seekBar.setProgress(prefs.getInt(PROGRESOBARRA, 19));	

		textoTitulo.setTextSize(TamanioTitulo);
		TextoSubtitulo.setTextSize(TamnioSubtitulo);
		TextoInfo.setTextSize(TamanioInfo);
		
		
		
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) 
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) 
			{
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) 
			{

					textoTitulo.setTextSize(progress);
					TextoSubtitulo.setTextSize(progress-2);
					TextoInfo.setTextSize(progress-4);
					Tamanio = progress;
					
					
				
			}
		});

		
	}
	
	
	
	public void onClick(View vista)
	{
		if (vista.getId() == R.id.btnSalvar)
		{
			
			if (Tamanio <= 10)
			{
				Toast.makeText(getBaseContext(),"La fuente es muy pequeña, seleccione una más grande",Toast.LENGTH_SHORT).show();
				
			} else {
				
				prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putInt(TAMFUENTETITULO, Tamanio); 
				editor.putInt(TAMFUENTESUBTITULO, Tamanio - 2); 
				editor.putInt(TAMFUENTEINFO, Tamanio -4 ); 
				editor.putInt(PROGRESOBARRA,Tamanio);
				editor.commit(); 
				
				Toast.makeText(getBaseContext(),"ConfiguracionesActivity guardadas con éxito ",Toast.LENGTH_SHORT).show();
			
			}
		}
		
		if (vista.getId() == R.id.btnBorrar)
		{
			prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
			editor.putInt(TAMFUENTETITULO, 19); 
			editor.putInt(TAMFUENTESUBTITULO, 17); 
			editor.putInt(TAMFUENTEINFO, 15); 
			editor.putInt(PROGRESOBARRA,19);
			editor.commit(); 
		
			editor.commit();
			seekBar.setProgress(19);
			Toast.makeText(getBaseContext(),"ConfiguracionesActivity restaurdas con éxito ",Toast.LENGTH_SHORT).show();
			
		}
	
	}
}
