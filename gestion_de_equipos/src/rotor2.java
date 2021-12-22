
import java.util.Scanner;

public class rotor2{

	public static void main (String [] args){

		// ROTOR 2

		Scanner sc = new Scanner(System.in);
		Scanner sh = new Scanner (System.in);

		System.out.println("Frase para Encriptar: ");
			String tense = sc.nextLine();

		System.out.println("Valor Encriptacion Inicial: ");
			int valor_encript = sc.nextInt();

		System.out.println();
		String encript_tense=cifrado_rotor2 (tense, valor_encript);
		System.out.println("Codificacion: "+encript_tense);

		String prueba_cifrada="3n[ormp I4V/_2WBXqcexdi Ra-g' 6n[eS 3tiavt|c..";
		System.out.println("Comparacion: "+encript_tense.equals(prueba_cifrada));

		System.out.println("-------------------------------------------------");

		System.out.println("Frase para Desencriptar: ");
			String encriptado = sh.nextLine();

		System.out.println("Valor Desencriptacion Inicial: ");
			int valor_desencript = sc.nextInt();

		System.out.println();
		String desenc_tense=descifrado_rotor2 (encriptado, valor_desencript);
		System.out.println("Decodificacion: "+desenc_tense);
		
		String prueba_real="Informe 345/32 Buque de Carga en el Atlantico.";
		System.out.println("Comparacion: " +desenc_tense.equals(prueba_real));

	}

	public static char cifrar (char letra, int valor){

		int codigo=(int)letra;
		int desplazamiento=codigo+valor%95;
		int resultado;
		if (desplazamiento>126)resultado=desplazamiento-95;
		else resultado=desplazamiento;
		return (char)resultado;
	}

	public static char descifrar (char letra, int valor){

		int codigo=(int)letra;
		int desplazamiento=codigo-valor%95;
		int resultado;
		if (desplazamiento<32)resultado=desplazamiento+95;
		else resultado=desplazamiento;
		return (char)resultado;
	}

	public static String cifrado_rotor2 (String tense, int valor){

		String final_tense="";

		for (int k=0; k<tense.length();k++){

			if (k%2==0 && ' '<=tense.charAt(k) && tense.charAt(k)<='~'){

				char result = cifrar(tense.charAt(k), valor);
				final_tense+=result;
				valor+=11;

			}else{
				final_tense+=tense.charAt(k);
			}
		}
		return final_tense;
	}

	public static String descifrado_rotor2 (String tense, int valor){

		String desenc_tense="";

		for (int k=0; k<tense.length(); k++){

			if (k%2==0 && ' '<=tense.charAt(k) && tense.charAt(k)<='~'){

				char result = descifrar(tense.charAt(k), valor);
				desenc_tense+=result;
				valor=valor+11;

			}else{
				desenc_tense+=tense.charAt(k);
			}
		}
		return desenc_tense;
	}
}
