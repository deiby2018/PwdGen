
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

		int nroContrase�as = Integer.parseInt(var.menu[8][1]);
		String contrase�as[] = new String[nroContrase�as];
		boolean pwdDifferent = false;

		while (!pwdDifferent) {
			for (int i = 0; i < nroContrase�as; i++) {
				contrase�as[i] = var.generadorContrase�as(var.menu);
			}
			if (nroContrase�as < 2)
				break;
			for (int i = 0; i < nroContrase�as; i++) {
				for (int j = 0; j < nroContrase�as; j++) {
					if (i != j)
						// assertTrue("No soy iguales",
						// contrase�as[i]!=contrase�as[j]);
						if (contrase�as[i] == contrase�as[j] && i != j) {
							pwdDifferent = false;
							break;
						}
					if (contrase�as[i] != contrase�as[j] && i != j) {
						pwdDifferent = true;
					}
				}
			}
		}
		for (int i = 0; i < contrase�as.length; i++)
			System.out.println(contrase�as[i]);
	}
}

