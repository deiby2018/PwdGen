
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

		int nroContraseņas = Integer.parseInt(var.menu[8][1]);
		String contraseņas[] = new String[nroContraseņas];
		boolean pwdDifferent = false;

		while (!pwdDifferent) {
			for (int i = 0; i < nroContraseņas; i++) {
				contraseņas[i] = var.generadorContraseņas(var.menu);
			}
			if (nroContraseņas < 2)
				break;
			for (int i = 0; i < nroContraseņas; i++) {
				for (int j = 0; j < nroContraseņas; j++) {
					if (i != j)
						// assertTrue("No soy iguales",
						// contraseņas[i]!=contraseņas[j]);
						if (contraseņas[i] == contraseņas[j] && i != j) {
							pwdDifferent = false;
							break;
						}
					if (contraseņas[i] != contraseņas[j] && i != j) {
						pwdDifferent = true;
					}
				}
			}
		}
		for (int i = 0; i < contraseņas.length; i++)
			System.out.println(contraseņas[i]);
	}
}

