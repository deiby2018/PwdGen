
public class PwdGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PwdGenMethod var = new PwdGenMethod();

		if (args.length == 0) {
			var.opcPwdGen = " ";
		} else {

			for (int i = 0; i < args.length; i++) {
				var.opcPwdGen = var.opcPwdGen + args[i] + " ";

			}
		}

		var.OpcGenPwd();

		int nroContraseñas = Integer.parseInt(var.menu[8][1]);
		String contraseñas[] = new String[nroContraseñas];
		boolean pwdDifferent = false;

		while (!pwdDifferent) {
			for (int i = 0; i < nroContraseñas; i++) {
				contraseñas[i] = var.generadorContraseñas(var.menu);
			}
			if (nroContraseñas < 2)
				break;
			for (int i = 0; i < nroContraseñas; i++) {
				for (int j = 0; j < nroContraseñas; j++) {
					if (i != j)
						// assertTrue("No soy iguales",
						// contraseñas[i]!=contraseñas[j]);
						if (contraseñas[i] == contraseñas[j] && i != j) {
							pwdDifferent = false;
							break;
						}
					if (contraseñas[i] != contraseñas[j] && i != j) {
						pwdDifferent = true;
					}
				}
			}
		}
		for (int i = 0; i < contraseñas.length; i++)
			System.out.println(contraseñas[i]);
	}
}

