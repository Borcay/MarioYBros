import java.util.ArrayList;

public class PersonajesDeMario {

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

    // Enemigo de ejemplo para recibir los ataques
    public static class Orco extends Personaje {
        public Orco() {
            super("Orco", 2, 200);
        }

        @Override
        public void atacar(Personaje obj) {
            obj.recibirDano(15);
        }
    }

    public static void main(String[] args) {
        ArrayList<Personaje> equipo = new ArrayList<>();
        equipo.add(new Mario());   // ← corregido
        equipo.add(new Luigi());
        equipo.add(new Toad());

        Personaje orco = new Orco(); // ← definido correctamente
        System.out.println("Antes: " + orco);

        for (Personaje p : equipo) {
            p.atacar(orco);          // ← POLIMORFISMO ✨
            System.out.println(p.nombre + " atacó → " + orco);
        }
    }
}