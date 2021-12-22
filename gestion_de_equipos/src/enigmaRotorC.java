import java.util.Scanner;
public class enigmaRotorC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el mensaje que desea cifrar/descifrar: ");
		String frase = sc.nextLine();
		System.out.println("Introduce A para encriptar");
		System.out.println("Introduce B para desencriptar");
		char opcion = Character.toUpperCase(sc.nextLine().charAt(0));
		System.out.print("Introduce el valor: ");
		int valor = sc.nextInt();

		String resultado = "";

		switch (opcion) {

		case 'A':
			cifrarA(frase, resultado, valor);
			break;

		case 'B':
			descifrarA(frase, resultado, valor);
			break;

		default:
			System.out.println("Esta función es inválida");
			break;
		}

	}
//cifrar**********************************************************************************
	
	
	public static void cifrarA(String frase, String resultado, int valor) {


		for (int i=0;i<frase.length();) {

			for (int j=0;j<3 && j<frase.length();j++) {
				char letra = frase.charAt(i);
				resultado+=Cifrar(letra, valor);
				i++;

			}
			for(int j=0;j<3 && i<frase.length();j++) {
				char letra = frase.charAt(i);
				resultado+=letra;
				i++;
				}

		}
		System.out.println(resultado);
	}

	//cifrar**********************************************************************************
	
	
	
	public static void descifrarA(String frase, String resultado, int valor) {


		for (int i=0;i<frase.length();) {

			for (int j=0;j<3 && j<frase.length();j++) {
				char letra = frase.charAt(i);
				resultado+=Descifrar(letra, valor);
				i++;

			}
			for(int j=0;j<3 && i<frase.length();j++) {
				char letra = frase.charAt(i);
				resultado+=letra;
				i++;
				}

		}
		System.out.println(resultado);
	}



	//funciones cifrar y descifrar************************


	public static char Cifrar (char letra, int valor) {

		int codigo=(int)letra;
		int desplazamiento = codigo+valor%95;
		int resultado;
		if (desplazamiento>126) resultado=desplazamiento-95;
		else resultado=desplazamiento;
		return (char)resultado;


	}
	public static char Descifrar (char letra, int valor) {

		int codigo=(int)letra;
		int desplazamiento = codigo-valor%95;
		int resultado;
		if (desplazamiento<32) resultado=desplazamiento+95;
		else resultado=desplazamiento;
		return (char)resultado;

	}



}
