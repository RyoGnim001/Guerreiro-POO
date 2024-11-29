import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------------");

        Guerreiro guerreiro1 = new Guerreiro(1, "Lucas");
        Guerreiro guerreiro2 = new Guerreiro(2, "Rhavy");

        System.out.println("-----------------------");

        System.out.println("Estado inicial dos guerreiros:");
        System.out.println(guerreiro1.StatusGuerreiro());
        System.out.println(guerreiro2.StatusGuerreiro());

        System.out.println("-----------------------");

        guerreiro1.lutarLaço(guerreiro2);

        System.out.println("-----------------------");

        Random random = new Random();
        Guerreiro guerreiroAlimentado = random.nextBoolean() ? guerreiro1 : guerreiro2;
        guerreiroAlimentado.alimentar();

        System.out.println("-----------------------");

        System.out.println("\nEstado após alimentação:");
        System.out.println(guerreiro1.StatusGuerreiro());
        System.out.println(guerreiro2.StatusGuerreiro());

        System.out.println("-----------------------");

        guerreiro1.lutarRecursivo(guerreiro2);

        System.out.println("-----------------------");

        System.out.println("\nEstado final dos guerreiros:");
        System.out.println(guerreiro1.StatusGuerreiro());
        System.out.println(guerreiro2.StatusGuerreiro());
    }
}
