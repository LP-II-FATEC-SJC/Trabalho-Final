package app;

import app.models.repositories.VeiculoRepositorySingleton;

public class Main {
    public static void main(String[] args) {
        VeiculoRepositorySingleton veiculoRepository = VeiculoRepositorySingleton.getInstance();
    }
}