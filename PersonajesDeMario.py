from abc import ABC, abstractmethod

class Personaje(ABC):
    def _init_(self, nombre: str, nivel: int, puntos_vida: int):
        self.nombre = nombre
        self.nivel = nivel
        self.puntos_vida = puntos_vida

    def recibir_dano(self, d: int):
        self.puntos_vida = max(0, self.puntos_vida - d)

    @abstractmethod
    def atacar(self, obj: "Personaje"):
        pass

    def _str_(self):
        return f"{self.nombre} (nivel {self.nivel}, vida {self.puntos_vida})"
