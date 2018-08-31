package gameShengDouShi;
public class Hero {
	static double baseDamage;
	static double probCrit;
	static double critDamage;
	
	public static void setBaseDamage(double bd) {
		if(bd == 0)
			throw new RuntimeException("�����˺���������");
		baseDamage = bd;
	}

	public static void setProbCrit(double pc) {
		if(pc == 0)
			throw new RuntimeException("�����ȼ���������");		
		probCrit = pc / 20 / 100;
	}
	
	public static void setCritDamage(double cd) {
		if(cd == 0)
			throw new RuntimeException("�����˺���������");
		critDamage = cd / 100;
	}
	
	public static double physicalDamageCoefficient() {
		return (Math.random() > probCrit) ? 1 : critDamage + 1;		
	}
}
