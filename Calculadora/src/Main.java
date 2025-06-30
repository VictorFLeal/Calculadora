import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> historico = new ArrayList<>();
        int opcao;

        while (true) {
            System.out.println("======= CALCULADORA JAVA =======");
            System.out.println("[1] Soma");
            System.out.println("[2] Subtração");
            System.out.println("[3] Multiplicação");
            System.out.println("[4] Divisão");
            System.out.println("[0] Sair");
            System.out.print("Escolha a operação: ");

            try {
                opcao = entrada.nextInt();

                if (opcao == 0) {
                    System.out.println("\nEncerrando calculadora...");
                    break;
                }

                System.out.print("Digite o primeiro número: ");
                double num1 = entrada.nextDouble();

                System.out.print("Digite o segundo número: ");
                double num2 = entrada.nextDouble();

                double resultado = 0;
                boolean operacaoValida = true;
                String registro = "";

                switch (opcao) {
                    case 1:
                        resultado = Calculadora.somar(num1, num2);
                        registro = num1 + " + " + num2 + " = " + resultado;
                        break;
                    case 2:
                        resultado = Calculadora.subtrair(num1, num2);
                        registro = num1 + " - " + num2 + " = " + resultado;
                        break;
                    case 3:
                        resultado = Calculadora.multiplicar(num1, num2);
                        registro = num1 + " * " + num2 + " = " + resultado;
                        break;
                    case 4:
                        try {
                            resultado = Calculadora.dividir(num1, num2);
                            registro = num1 + " / " + num2 + " = " + resultado;
                        } catch (ArithmeticException e) {
                            System.out.println("Erro: " + e.getMessage());
                            operacaoValida = false;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        operacaoValida = false;
                }

                if (operacaoValida) {
                    System.out.println("Resultado: " + resultado);
                    historico.add(registro);
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: valor inválido. Digite apenas números.");
                entrada.nextLine(); // limpa entrada errada
            }

            System.out.println();
        }

        // Exibe histórico
        System.out.println("\n===== HISTÓRICO DE OPERAÇÕES =====");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada.");
        } else {
            for (String h : historico) {
                System.out.println(h);
            }
        }

        entrada.close();
    }
}