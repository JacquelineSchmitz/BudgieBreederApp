package de.syntaxinstitut.budgiebreeder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.syntaxinstitut.budgiebreeder.databinding.ActivityMainBinding
import kotlin.system.exitProcess


/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: ActivityMainBinding

    /* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     *
     * @param savedInstanceState      Save state vom view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    fun quitApp(view: View) {
        this@MainActivity.finish()
        exitProcess(0)
    }
}

//MainActivity().quitApp(view)