package org.example.model;

public class Podcast extends Midia{
    public Podcast(String titulo, String artista, int duracao) {
        super(titulo, artista, duracao);
    }

    @Override
    public String toString() {
        String texto = "———————————————————————————————————————————————————————————————————————————————————————————————————————\n"+ "»  "+super.getTitulo() + " - " + super.getArtista() + "\n Duração: " + formatarDuracao(super.getDuracao()) + " - Tipo: " + this.getClass().getSimpleName();
        return texto;
    }
}
