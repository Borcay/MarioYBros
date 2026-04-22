import java.util.ArrayList;

public class Nintendo {

    public abstract static class Personaje {
        protected String nombre;
        protected int nivel, puntosVida;

        public Personaje(String nombre, int nivel, int vida) {
            this.nombre = nombre;
            this.nivel = nivel;
            this.puntosVida = vida;
        }

        public void recibirDano(int d) {
            puntosVida = Math.max(0, puntosVida - d);
        }

        public abstract void atacar(Personaje obj);

        @Override
        public String toString() {
            return nombre + " (nivel " + nivel + ", vida " + puntosVida + ")";
        }
    }

    public static class Mario extends Personaje {
        private boolean tieneStar;

        public Mario() {
            super("Mario", 3, 100);
            this.tieneStar = false;
        }

        @Override
        public void atacar(Personaje obj) {
            obj.recibirDano(20);
        }
    }

    public static class Luigi extends Personaje {
        private boolean tieneStar;

        public Luigi() {
            super("Luigi", 3, 100);
            this.tieneStar = false;
        }

        @Override
        public void atacar(Personaje obj) {
            obj.recibirDano(20);
        }
    }

    public static class Toad extends Personaje {
        private boolean tieneStar;

        public Toad() {
            super("Toad", 1, 50);
            this.tieneStar = false;
        }

        @Override
        public void atacar(Personaje obj) {
            obj.recibirDano(20);
        }
    }