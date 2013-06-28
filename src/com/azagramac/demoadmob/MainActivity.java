/*
 * Autor: Jose L. Azagra
 * Twitter: @JoseLAzagra
 * Blog: http://scriptogr.am/azagramac
 * Licenses: GPL
 */

package com.azagramac.demoadmob;

import com.google.ads.Ad;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String URL_GooglePlay = "https://play.google.com/store/search?q=azagramac";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// AdMob
        AdView adViewTab = (AdView) this.findViewById(R.id.adView);
    	adViewTab.loadAd(new AdRequest());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Establecemos los botones del Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.menuAcerca:
    		
    		// Theme del AlertDialog
    		ContextThemeWrapper wrapper = new ContextThemeWrapper(this, android.R.style.Theme_Holo_Light);
    		final LayoutInflater inflater = (LayoutInflater) wrapper.getSystemService(LAYOUT_INFLATER_SERVICE);
    		
    		// Muestra un AlertDialog
    		AlertDialog.Builder builder = new AlertDialog.Builder(wrapper);
    		builder.setTitle(getString(R.string.app_name))
            .setMessage(getText(R.string.hello_world))
            
            .setCancelable(false)
            .setIcon(R.drawable.ic_launcher)
            
            // Boton Salir
            .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                	finish();
                }
            })
            // Boton Votar
            .setNeutralButton("Mis Apps", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                	Intent abrirGooglePlay = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_GooglePlay));
                	startActivity(abrirGooglePlay);
                	Toast.makeText(getApplicationContext(), "No te olvides de Valorar la App ;-)", Toast.LENGTH_SHORT).show();
                }
            })
            // Boton OK
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                	dialog.cancel();
                }
            });
        builder.create().show();
        
    		return true;
    		
    	// Opcion del Menu
    	case R.id.menuSalir:
    		Toast.makeText(this, "Gracias!", Toast.LENGTH_SHORT).show();
    		//Principal.this.finish();
    		finish();
    		return true;
    		
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
}