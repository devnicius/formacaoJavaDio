import java.math.BigDecimal;
import java.util.Scanner;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.util.Locale;

public class ContaTerminal {
    public static String nomeCliente;
    public static String agencia;
    public static Integer numero;
    public static BigDecimal saldo;

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        decimalFormatSymbols.setDecimalSeparator('.');
        
        Scanner resposta = new Scanner(System.in);

        do {
            System.out.println("Por favor, digite o seu nome completo:");
            nomeCliente = resposta.nextLine();

            System.out.println("Digite o número da agência:");
            agencia = resposta.nextLine();

            System.out.println("Agora, digite o número da conta:");
            numero = resposta.nextInt();

            System.out.println("Insira o valor do seu primeiro depósito:");
            saldo = new BigDecimal(new DecimalFormat("0.00", decimalFormatSymbols).format(resposta.nextBigDecimal()));
            resposta.close();
        } while (nomeCliente.isEmpty() && agencia.isEmpty() && numero.equals(null) && saldo.equals(null));

        System.out.println("Conta criada!");
        System.out.println("""
                    Olá %s. Obrigado por criar uma conta em nosso banco.
                    Sua agência é %s, conta %s e seu saldo atual é %s
                """.formatted(nomeCliente, agencia, numero, saldo));
    }
}
