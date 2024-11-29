import java.util.Random;

public class Guerreiro {
    private int codigo;
    private String nome;
    private int energia;

    public Guerreiro(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.energia = 5;
    }

    public int getEnergia() {
        return energia;
    }

    public String getNome() {
        return nome;
    }

    public void incremento() {
        if (energia < 5) {
            energia++;
        }
    }

    public void decremento() {
        if (energia > 0) {
            energia--;
            if (energia == 0) {
                System.out.println(nome + " está sem energia!");
            }
        }
    }

    public void alimentar() {
        incremento();
        System.out.println(nome + " se alimentou e agora tem " + energia + " de energia.");
    }

    private int atacar() {
        Random random = new Random();
        return random.nextInt(2); // 0 ou 1
    }

    public void lutarLaço(Guerreiro oponente) {
        System.out.println("\nLuta iniciada entre " + nome + " e " + oponente.nome);
        while (energia > 0 && oponente.energia > 0) {
            if (atacar() == 1) {
                oponente.decremento();
                System.out.println(nome + " atacou com sucesso! Energia de " + oponente.nome + ": " + oponente.energia);
            } else {
                System.out.println(nome + " falhou no ataque!");
            }

            if (oponente.energia > 0 && oponente.atacar() == 1) {
                decremento();
                System.out.println(oponente.nome + " atacou com sucesso! Energia de " + nome + ": " + energia);
            } else {
                System.out.println(oponente.nome + " falhou no ataque!");
            }
        }

        if (energia > 0) {
            System.out.println("\n" + nome + " venceu a luta!");
        } else {
            System.out.println("\n" + oponente.nome + " venceu a luta!");
        }
    }

    public void lutarRecursivo(Guerreiro oponente) {
        if (energia == 0 || oponente.energia == 0) {
            if (energia > 0) {
                System.out.println("\n" + nome + " venceu a luta recursiva!");
            } else {
                System.out.println("\n" + oponente.nome + " venceu a luta recursiva!");
            }
            return;
        }

        if (atacar() == 1) {
            oponente.decremento();
            System.out.println(nome + " atacou com sucesso! Energia de " + oponente.nome + ": " + oponente.energia);
        } else {
            System.out.println(nome + " falhou no ataque!");
        }

        if (oponente.energia > 0 && oponente.atacar() == 1) {
            decremento();
            System.out.println(oponente.nome + " atacou com sucesso! Energia de " + nome + ": " + energia);
        } else {
            System.out.println(oponente.nome + " falhou no ataque!");
        }

        lutarRecursivo(oponente);
    }

    public String StatusGuerreiro() {
        return "Guerreiro [Código=" + codigo + ", Nome=" + nome + ", Energia=" + energia + "]";
    }
}
