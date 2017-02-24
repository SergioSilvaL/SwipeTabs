package com.tecnologiassilva.swipetabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


    private Adapter_ViewPagerPrincipal mAdapter_viewPagerPrincipal;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Set Tool Bar
        // Iniciamos la barra de herramientas.
        Toolbar toolbar = (Toolbar) findViewById(R.id.ToolbarPrincipal);
        setSupportActionBar(toolbar);


        // Iniciamos la barra de tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.TabLayoutPrincipal);

        // Añadimos las 3 tabs de las secciones.
        // Le damos modo "fixed" para que todas las tabs tengan el mismo tamaño. También le asignamos una gravedad centrada.
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);


        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());


//      Iniciamos el viewPager.
        mViewPager = (ViewPager) findViewById(R.id.ViewPagerPrincipal);

        // Creamos el adaptador, al cual le pasamos por parámtro el gestor de Fragmentos y muy importante, el nº de tabs o secciones que hemos creado.
        mAdapter_viewPagerPrincipal =
                new Adapter_ViewPagerPrincipal(
                        getSupportFragmentManager(),
                        tabLayout.getTabCount(),this);

        // Y los vinculamos.
        mViewPager.setAdapter(mAdapter_viewPagerPrincipal);

        tabLayout.setupWithViewPager(mViewPager);


    }
}
