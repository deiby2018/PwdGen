import java.util.Random;
import java.util.Scanner;

public class PwdGenMethod {

	Scanner input = new Scanner(System.in);
	Random random = new Random();
	public static String opcPwdGen;
	String[] mayuscula = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	String[] minuscula = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "v", "w", "x", "y", "z" };
	String[] numeros = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	String[] simbolos = { "$", "#", "&", "/", "(", ")", "=", "?", "�", "�", "�", "|", "[", "[", "]" };
	String[] ambiguos = { "i", "I", "L", "l", "1", "o", "O", "0" };
	String ambiguosCadena = "iILl1oO0";
	String[][] menu = { { "-SIZE:", "16" }, // Valores por defecto para generar el password 
			{ "-U", "true" },  //mayuscula, minuscula, numeros
			{ "-L", "true" }, 
			{ "-N", "true" }, 
			{ "-SM", "false" },
			{ "-A", "false" }, 
			{ "-E:", "" }, 
			{ "-C", "false" },
			{ "-T:", "1" } };


	public void OpcGenPwd() {
		// > java PwdGen �Size:16 �U �L �N �SM �A �E:[]{}@ �T:3 -C
		// default size 16, mayusculas, minusculas, numeros
		// opcPwdGen = input.nextLine();
		Boolean temp = opcPwdGen.contains("-?");
		if (temp) {
			System.out.println("Ejemplo: �SIZE:16 �U �L �N �SM �A �E:[]{}@ �T:3 -C ");
			System.out.println("-SIZE: Tama�o de la contrase�a");
			System.out.println("-U: Incluir letras en may�sculas");
			System.out.println("-L: Incluir letras en min�sculas");
			System.out.println("-N: Incluir n�meros");
			System.out.println("-SM: Incluir simbolos");
			System.out.println("-A: Excluye los caracteres antiguos");
			System.out.println("-E: Excluir los simbolos suministrados");
			System.out.println("-C: Copia de la Contrase�a");
			System.out.println("-T: Generar Contrase�as");
			System.out.println("");
			//System.out.print("Digite las opciones que desea: ");
			// opcPwdGen = input.nextLine();
			System.out.println();
		}

		// Validando parametro para que cambien los valores por defecto
		if (opcPwdGen.contains(menu[1][0]) || opcPwdGen.contains(menu[2][0])) {
			menu[1][1] = "false";
			menu[2][1] = "false";
			menu[3][1] = "false";
		}

		if (opcPwdGen.contains(menu[0][0]))// -SIZE: Tama�o de la contrase�a
		{
			String searchString = menu[0][0];
			String cadTemp = "";
			int startIndex = opcPwdGen.indexOf(searchString);
			cadTemp = opcPwdGen.substring(startIndex);
			int endIndex = cadTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = cadTemp.length();

			startIndex = menu[0][0].length();
			cadTemp = cadTemp.substring(startIndex, endIndex);

			menu[0][1] = cadTemp;
		}

		if (opcPwdGen.contains(menu[1][0]))// -U: Incluir letras en may�sculas"
			menu[1][1] = "true";
		if (opcPwdGen.contains(menu[2][0]))// -L: Incluir letras en min�sculas"
			menu[2][1] = "true";
		if (opcPwdGen.contains(menu[3][0]))// -N: Incluir n�meros"
			menu[3][1] = "true";
		if (opcPwdGen.contains(menu[4][0]))// -S: Incluir simbolos"
			menu[4][1] = "true";
		if (opcPwdGen.contains(menu[5][0]))// -A: Excluye los caracteres
											// ambiguos
			menu[5][1] = "true";
		if (opcPwdGen.contains(menu[6][0]))// -E: Excluir los simbolos
											// suministrados
		{
			String searchString = menu[6][0];
			String cadTemp = "";
			int startIndex = opcPwdGen.indexOf(searchString);
			cadTemp = opcPwdGen.substring(startIndex);
			int endIndex = cadTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = cadTemp.length();
			startIndex = menu[6][0].length();
			cadTemp = cadTemp.substring(startIndex, endIndex);

			menu[6][1] = cadTemp;
		}

		if (opcPwdGen.contains(menu[7][0]))// -C: Copia de la Contrase�a
			menu[7][1] = "true";
		if (opcPwdGen.contains(menu[8][0]))// -T: Generar Contrase�as
		{
			String searchString = menu[8][0];
			String cadTemp = "";
			int startIndex = opcPwdGen.indexOf(searchString);
			cadTemp = opcPwdGen.substring(startIndex);
			int endIndex = cadTemp.indexOf(" ");
			if (endIndex == -1)
				endIndex = cadTemp.length();
			startIndex = menu[6][0].length();
			cadTemp = cadTemp.substring(startIndex, endIndex);

			menu[8][1] = cadTemp;
		}

	}

	public String generadorContrase�as(String[][] opciones) {

		int tama�oPwd = Integer.parseInt(opciones[0][1]);
		int cont = 0;
		String contrase�a = "";
		while (cont < tama�oPwd) {

			switch (random.nextInt(5)) {
			case 1:
				if (opciones[1][1] == "true")// mayuscula
				{
					String letraMay = mayuscula[random.nextInt(25)];
					if (!opciones[6][1].contains(letraMay) && opciones[5][1] == "false")// Excluyen
																						// caracteres
					{
						contrase�a = contrase�a + letraMay;
						cont++;
					}
					if (!opciones[6][1].contains(letraMay) && opciones[5][1] == "true")// Excluyen
																						// ambiguos
					{
						if (!ambiguosCadena.contains(letraMay)) {
							contrase�a = contrase�a + letraMay;
							cont++;
						}
					}

				}
				break;
			case 2:
				if (opciones[2][1] == "true")// minuscula
				{
					String letraMinus = minuscula[random.nextInt(25)];
					if (!opciones[6][1].contains(letraMinus) && opciones[5][1] == "false")// Excluyen
																							// caracteres
					{
						contrase�a = contrase�a + letraMinus;
						cont++;
					}
					if (!opciones[6][1].contains(letraMinus) && opciones[5][1] == "true")// Excluyen
																							// ambiguos
					{
						if (!ambiguosCadena.contains(letraMinus)) {
							contrase�a = contrase�a + letraMinus;
							cont++;
						}
					}
				}
				break;
			case 3:
				if (opciones[3][1] == "true")// numeros
				{
					String nro = numeros[random.nextInt(9)];
					if (!opciones[6][1].contains(nro) && opciones[5][1] == "false")// Excluyen
																					// caracteres
					{
						contrase�a = contrase�a + nro;
						cont++;
					}
					if (!opciones[6][1].contains(nro) && opciones[5][1] == "true")// Excluyen
																					// ambiguos
					{
						if (!ambiguosCadena.contains(nro)) {
							contrase�a = contrase�a + nro;
							cont++;
						}
					}
				}
				break;
			case 4:
				if (opciones[4][1] == "true")// simbolos
				{
					String simb = simbolos[random.nextInt(14)];
					if (!opciones[6][1].contains(simb) && opciones[5][1] == "false")// Excluyen
																					// caracteres
					{
						contrase�a = contrase�a + simb;
						cont++;
					}
					if (!opciones[6][1].contains(simb) && opciones[5][1] == "true")// Excluyen
																					// ambiguos
					{
						if (!ambiguosCadena.contains(simb)) {
							contrase�a = contrase�a + simb;
							cont++;
						}
					}
				}
				break;
			default:
				break;
			}

		}
		return contrase�a;

	}

}
