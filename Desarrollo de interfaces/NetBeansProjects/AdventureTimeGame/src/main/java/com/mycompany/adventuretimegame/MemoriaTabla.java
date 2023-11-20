/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventuretimegame;

import com.mycompany.adventuretimegame.PantallaTabla.JuegoResult;
import java.util.ArrayList;
import java.util.List;


public class MemoriaTabla {
    private static MemoriaTabla instancia = new MemoriaTabla();
    private List<PantallaTabla.JuegoResult> resultadosAnteriores = new ArrayList<>();

    private MemoriaTabla() {
        
    }

    public static MemoriaTabla getInstancia() {
        return instancia;
    }

    public List<PantallaTabla.JuegoResult> getResultadosAnteriores() {
        return resultadosAnteriores;
    }

    public void agregarResultado(JuegoResult resultado) {
        resultadosAnteriores.add(resultado);
        System.out.println(resultadosAnteriores.toString());
    }
}
