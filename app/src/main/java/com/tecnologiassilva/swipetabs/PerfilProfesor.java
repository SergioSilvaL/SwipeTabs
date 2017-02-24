package com.tecnologiassilva.swipetabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static com.tecnologiassilva.swipetabs.R.id.tablayout_Perfil;

public class PerfilProfesor extends AppCompatActivity {

    private Perfil_Profesor_Tab_Adapter mAdapter_viewPagerPrincipal;
    private  ViewPager mViewPager;
    private String profesor_nombre;
    private String profesor_carrera;

    private TextView  mProfesor_Nombre, mProfesor_Carrera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profesor);

        setUpTabLayoutViewPager();

        Intent i = getIntent();

        profesor_nombre = i.getStringExtra("Nombre_Maestro");

        profesor_carrera = i.getStringExtra("Nombre_Carrera");


        //Capture Views


        mProfesor_Nombre = (TextView) findViewById(R.id.profesor_nombre);
        mProfesor_Nombre.setText(profesor_nombre);
        Log.v("LogV ", "" + profesor_nombre);

        mProfesor_Carrera = (TextView) findViewById(R.id.profesor_Carrera);
        mProfesor_Carrera.setText(profesor_carrera);


    }

    private void setUpTabLayoutViewPager(){
        // Iniciamos la barra de tabs
        final TabLayout tabLayout = (TabLayout) findViewById(tablayout_Perfil);

        // Añadimos las 3 tabs de las secciones.
        // Le damos modo "fixed" para que todas las tabs tengan el mismo tamaño. También le asignamos una gravedad centrada.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());



        //Iniciamos el ViewPager.
        mViewPager = (ViewPager) findViewById(R.id.PerfilPager);


        mAdapter_viewPagerPrincipal = new Perfil_Profesor_Tab_Adapter(
                getSupportFragmentManager(),tabLayout.getTabCount(),this
        );


        mViewPager.setAdapter(mAdapter_viewPagerPrincipal);



        tabLayout.setupWithViewPager(mViewPager);

    }


}
