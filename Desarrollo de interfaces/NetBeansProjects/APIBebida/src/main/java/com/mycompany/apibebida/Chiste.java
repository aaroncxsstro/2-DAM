
package org.openjfx.jokes;

public class Chiste {

    String chiste;

    public Chiste(String chiste) {
        this.chiste = chiste;
    }

    public String getChiste() {
        return chiste;
    }

    public void setChiste(String chiste) {
        this.chiste = chiste;
    }

    @Override
    public String toString() {
        return getChiste();
    }
}
