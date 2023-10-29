package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se utiliza en este ejemplo
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();

                // Cambiar el tamaño de la imagen según el valor ingresado
                int newSize;
                try {
                    newSize = Integer.parseInt(inputText);
                } catch (NumberFormatException e) {
                    newSize = 1; // Valor predeterminado si no se ingresa un número válido
                }

                // Limitar el tamaño entre 1 y 3
                newSize = Math.min(3, Math.max(1, newSize));

                // Cambiar el tamaño de la imagen
                int newImageSize = newSize * 100; // Ajusta el factor de escala según tus necesidades
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
}