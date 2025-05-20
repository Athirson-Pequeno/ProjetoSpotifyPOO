package org.example.model;

public class AudioBook extends Midia{
    public AudioBook(String titulo, String artista, int duracao) {
        super(titulo, artista, duracao);
    }

    @Override
    public String toString() {
        String texto = "———————————————————————————————————————————————————————————————————————————————————————————————————————\n"+ "»  "+super.getTitulo() + " - " + super.getArtista() + "\n Duração: " + formatarDuracao(super.getDuracao()) + " - Tipo: " + this.getClass().getSimpleName();
        return texto;
    }
}
