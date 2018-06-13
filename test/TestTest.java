import static org.junit.Assert.*;


import org.junit.Test;

public class TestTest {
	PwdGenMethod var2 = new PwdGenMethod();

	@Test
	public void testKeyWithUpperCase() {

		String opc = "-U";
		String pwd = "";
		var2.opcPwdGen = opc;

		var2.OpcGenPwd();
		pwd = var2.generadorContraseñas(var2.menu);
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z]*"));

	}

	@Test
	public void testKeyWithUpperAndNumberCase() {

		String opc = "-U -N";
		String pwd = "";
		var2.opcPwdGen = opc;

		var2.OpcGenPwd();
		pwd = var2.generadorContraseñas(var2.menu);
		System.out.println(pwd);
		assertEquals(true, pwd.matches("[A-Z|0-9]*"));

	}


}
