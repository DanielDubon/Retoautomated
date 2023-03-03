import java.util.Scanner;
import java.util.Stack;

public class AutomatadePila {

    public static boolean verificarCadena(String cadena) {
        Stack<Character> pila = new Stack<>();
        int index = 0;


        pila.push('$');


        char estado = '0';


        while (index < cadena.length()) {
            char simbolo = cadena.charAt(index);

            switch (estado) {
                case '0':
                    if (simbolo == 'a') {
                        pila.push('a');
                    } else {
                        estado = '1';
                    }
                    break;
                case '1':
                    if (simbolo == 'b') {;
                        pila.pop();
                    } else if (simbolo == 'c') {
                        estado = '2';
                        pila.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

            index++;
        }

        // Verificamos si hemos consumido toda la entrada y la pila está vacía
       try {
           return estado == '2' && pila.peek() == '$';
       }catch (Exception e){
           return false;
       }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese cadena a verificar: ");
        String cadena = in.nextLine();
         cadena = cadena +"c";
        System.out.println(verificarCadena(cadena));
    }
}
