package com.nansoft.ctppnocturno.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.nansoft.ctppnocturno.R;


public class InfoTecnicoActivity extends ActionBarActivity
{

    String nombrePref = "Preferencias";
    String TAMFUENTETITULO = "tamtitulo";
    String TAMFUENTESUBTITULO = "tamsubtitulo";
    String TAMFUENTEINFO = "taminfo";

    TextView Titulo1;
    TextView Introduccion;
    TextView Titulo2;
    TextView Requisitos;
    TextView Titulo3;
    TextView PerfilProfesional;
    TextView Titulo4;
    TextView OpcionTrabajo;
    TextView Titulo5;
    TextView Decimo;
    TextView MateriasDecimo;
    TextView Undecimo;
    TextView MateriasUndecimo;
    TextView Duodecimo;
    TextView MateriasDuodecimo;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layinfotecnico);

        Intent intent = getIntent();
        int idTecnico = intent.getIntExtra("idTecnico",-1);

        ImageView imgTecnico = (ImageView) findViewById(R.id.img);

        Titulo1 = (TextView)findViewById(R.id.titulo1);
        Introduccion = (TextView) findViewById(R.id.infotitulo1);

        Titulo2 = (TextView) findViewById(R.id.titulo2);
        Requisitos = (TextView) findViewById(R.id.infotitulo2);

        Titulo3 = (TextView) findViewById(R.id.titulo3);
        PerfilProfesional = (TextView) findViewById(R.id.infotitulo3);

        Titulo4 = (TextView) findViewById(R.id.titulo4);
        OpcionTrabajo = (TextView) findViewById(R.id.infotitulo4);

        Titulo5 = (TextView) findViewById(R.id.titulo5);

        Decimo = (TextView) findViewById(R.id.infotituloDecimo);
        MateriasDecimo = (TextView) findViewById(R.id.MateriasDecimo);

        Undecimo = (TextView) findViewById(R.id.infotituloUndecimo);
        MateriasUndecimo = (TextView) findViewById(R.id.MateriasUndecimo);

        Duodecimo = (TextView) findViewById(R.id.infotituloDuodecimo);
        MateriasDuodecimo = (TextView) findViewById(R.id.MateriasDuodecimo);

        int imagen = 0;
        String introduccion = "";
        String requisitos = "";
        String perfilProfesional = "";
        String opcionTrabajo = "";
        String materiasDecimo = "";
        String materiasUndecimo = "";
        String materiasDuodecimo = "";

        switch(idTecnico)
        {
            case 0:
                imagen = R.drawable.bancaenfinanzasm;
                introduccion = getResources().getString(R.string.introbf);
                requisitos = getResources().getString(R.string.requisitosbf);
                perfilProfesional = getResources().getString(R.string.perfilbf);
                opcionTrabajo = getResources().getString(R.string.trabajobf);
                materiasDecimo = getResources().getString(R.string.materiasdecibf);
                materiasUndecimo = getResources().getString(R.string.materiasundebf);
                materiasDuodecimo = getResources().getString(R.string.materiasduobf);
                break;

            case 1:
                imagen = R.drawable.contadorm;
                introduccion = getResources().getString(R.string.introco);
                requisitos = getResources().getString(R.string.requisitosco);
                perfilProfesional = getResources().getString(R.string.perfilco);
                opcionTrabajo = getResources().getString(R.string.trabajoco);
                materiasDecimo = getResources().getString(R.string.materiasdecico);
                materiasUndecimo = getResources().getString(R.string.materiasundeco);
                materiasDuodecimo = getResources().getString(R.string.materiasduoco);
                break;

            case 2:
                imagen = R.drawable.customerservicem;
                introduccion = getResources().getString(R.string.introeje);
                requisitos = getResources().getString(R.string.requisitoseje);
                perfilProfesional = getResources().getString(R.string.perfileje);
                opcionTrabajo = getResources().getString(R.string.trabajoeje);
                materiasDecimo = getResources().getString(R.string.materiasdecieje);
                materiasUndecimo = getResources().getString(R.string.materiasundeeje);
                materiasDuodecimo = getResources().getString(R.string.materiasduoeje);
                break;

            case 3:
                imagen = R.drawable.informaticamepresarialm;
                introduccion = getResources().getString(R.string.introinfe);
                requisitos = getResources().getString(R.string.requisitosinfe);
                perfilProfesional = getResources().getString(R.string.perfilinfe);
                opcionTrabajo = getResources().getString(R.string.trabajoinfe);
                materiasDecimo = getResources().getString(R.string.materiasdeciinfe);
                materiasUndecimo = getResources().getString(R.string.materiasundeinfe);
                materiasDuodecimo = getResources().getString(R.string.materiasduoinfe);
                break;

            case 4:
                imagen = R.drawable.redesm;
                introduccion = getResources().getString(R.string.introinfr);
                requisitos = getResources().getString(R.string.requisitosinfr);
                perfilProfesional = getResources().getString(R.string.perfilinfr);
                opcionTrabajo = getResources().getString(R.string.trabajoinfr);
                materiasDecimo = getResources().getString(R.string.materiasdeciinfr);
                materiasUndecimo = getResources().getString(R.string.materiasundeinfr);
                materiasDuodecimo = getResources().getString(R.string.materiasduoinfr);
                break;

            case 5:
                imagen = R.drawable.soportecomputadorasm;
                introduccion = getResources().getString(R.string.introinfs);
                requisitos = getResources().getString(R.string.requisitosinfs);
                perfilProfesional = getResources().getString(R.string.perfilinfs);
                opcionTrabajo = getResources().getString(R.string.trabajoinfs);
                materiasDecimo = getResources().getString(R.string.materiasdeciinfs);
                materiasUndecimo = getResources().getString(R.string.materiasundeinfs);
                materiasDuodecimo = getResources().getString(R.string.materiasduoinfs);
                break;

            case 6:
                imagen = R.drawable.logisticam;
                introduccion = getResources().getString(R.string.introlo);
                requisitos = getResources().getString(R.string.requisitoslo);
                perfilProfesional = getResources().getString(R.string.perfillo);
                opcionTrabajo = getResources().getString(R.string.trabajolo);
                materiasDecimo = getResources().getString(R.string.materiasdecilo);
                materiasUndecimo = getResources().getString(R.string.materiasundelo);
                materiasDuodecimo = getResources().getString(R.string.materiasduolo);
                break;

            case 7:
                imagen = R.drawable.secretariadom;
                introduccion = getResources().getString(R.string.introse);
                requisitos = getResources().getString(R.string.requisitosse);
                perfilProfesional = getResources().getString(R.string.perfilse);
                opcionTrabajo = getResources().getString(R.string.trabajose);
                materiasDecimo = getResources().getString(R.string.materiasdecise);
                materiasUndecimo = getResources().getString(R.string.materiasundese);
                materiasDuodecimo = getResources().getString(R.string.materiasduose);
                break;

            case 8:
                imagen = R.drawable.turismom;
                introduccion = getResources().getString(R.string.introtu);
                requisitos = getResources().getString(R.string.requisitostu);
                perfilProfesional = getResources().getString(R.string.perfiltu);
                opcionTrabajo = getResources().getString(R.string.trabajotu);
                materiasDecimo = getResources().getString(R.string.materiasdecitu);
                materiasUndecimo = getResources().getString(R.string.materiasundetu);
                materiasDuodecimo = getResources().getString(R.string.materiasduotu);
                break;

            default:
        }

        imgTecnico.setBackgroundResource(imagen);
        Introduccion.setText(introduccion);
        Requisitos.setText(requisitos);
        PerfilProfesional.setText(perfilProfesional);
        OpcionTrabajo.setText(opcionTrabajo);
        MateriasDecimo.setText(materiasDecimo);
        MateriasUndecimo.setText(materiasUndecimo);
        MateriasDuodecimo.setText(materiasDuodecimo);


    }

    @Override
    protected void onResume()
    {
        super.onResume();

        prefs = getSharedPreferences(nombrePref, MODE_PRIVATE);

        Titulo1.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
        Introduccion.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Titulo2.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
        Requisitos.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Titulo3.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
        PerfilProfesional.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Titulo4.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));
        OpcionTrabajo.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Titulo5.setTextSize(prefs.getInt(TAMFUENTETITULO, 19));

        Decimo.setTextSize(prefs.getInt(TAMFUENTESUBTITULO, 17));
        MateriasDecimo.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Undecimo.setTextSize(prefs.getInt(TAMFUENTESUBTITULO, 17));
        MateriasUndecimo.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

        Duodecimo.setTextSize(prefs.getInt(TAMFUENTESUBTITULO, 17));
        MateriasDuodecimo.setTextSize(prefs.getInt(TAMFUENTEINFO, 15));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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

        return super.onOptionsItemSelected(item);
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
