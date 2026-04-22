from abc import ABC, abstractmethod

class Personaje(ABC):
    def __init__(self, nombre: str, nivel: int, puntos_vida: int):
        self.nombre = nombre
        self.nivel = nivel
        self.puntos_vida = puntos_vida

    def recibir_dano(self, d: int):
        self.puntos_vida = max(0, self.puntos_vida - d)

    @abstractmethod
    def atacar(self, obj: "Personaje"):
        pass

    def __str__(self):
        return f"{self.nombre} (nivel {self.nivel}, vida {self.puntos_vida})"


class Mario(Personaje):
    def __init__(self):
        super().__init__("Mario", 3, 100)
        self.tiene_star = False

    def atacar(self, obj: Personaje):
        obj.recibir_dano(20)


class Luigi(Personaje):
    def __init__(self):
        super().__init__("Luigi", 3, 100)
        self.tiene_star = False

    def atacar(self, obj: Personaje):
        obj.recibir_dano(20)


class Toad(Personaje):
    def __init__(self):
        super().__init__("Toad", 1, 50)
        self.tiene_star = False

    def atacar(self, obj: Personaje):
        obj.recibir_dano(20)


class Orco(Personaje):
    def __init__(self):
        super().__init__("Orco", 2, 200)

    def atacar(self, obj: Personaje):
        obj.recibir_dano(15)


if __name__ == "__main__":
    equipo: list[Personaje] = [Mario(), Luigi(), Toad()]
    orco = Orco()

    print(f"Antes: {orco}")

    for p in equipo:
        p.atacar(orco)
        print(f"{p.nombre} atacó → {orco}")