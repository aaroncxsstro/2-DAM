package com.example.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText editText;
    private ImageView imageView;
    private Button botonIzquierdo;
    private Button botonDerecho;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        botonIzquierdo = findViewById(R.id.botonIzquierdo);
        botonDerecho = findViewById(R.id.botonDerecho);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio1);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se utiliza en este ejemplo
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();

                int newSize;
                try {
                    newSize = Integer.parseInt(inputText);
                } catch (NumberFormatException e) {
                    newSize = 1;
                }

                newSize = Math.min(3, Math.max(1, newSize));

                int newImageSize = newSize * 100;
                imageView.getLayoutParams().width = newImageSize;
                imageView.getLayoutParams().height = newImageSize;
                imageView.requestLayout();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se utiliza en este ejemplo
            }
        });
    }

    public void cambiarImagen1(View view) {
        imageView.setImageResource(R.drawable.imagen1);
        animacionApretar(view);
        reproducirSonido(R.raw.audio1);
    }

    public void cambiarImagen2(View view) {
        imageView.setImageResource(R.drawable.imagen2);
        animacionApretar(view);
        reproducirSonido(R.raw.audio1);
    }

    public void animacionApretar(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.apretar_animacion);
        view.startAnimation(anim);
    }

    private void reproducirSonido(int rawId) {
        // Reproducir el sonido asociado al botón
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, rawId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        // Liberar recursos del MediaPlayer cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
