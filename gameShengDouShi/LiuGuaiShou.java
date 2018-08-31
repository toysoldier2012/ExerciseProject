package gameShengDouShi;
import java.text.DecimalFormat;

public class LiuGuaiShou extends Hero {
	double damage = 0;
	DecimalFormat df = new DecimalFormat("0.00");
	
	public double firstSkill() {
		damage = baseDamage * 0;
		System.out.println("�˺�Ϊ��"+ df.format(damage));
		return damage;
	}

	public double secondSkill() {
		damage = baseDamage * 1.2 * physicalDamageCoefficient() * 2.1164;
		System.out.println("�˺�Ϊ��"+ df.format(damage));
		return damage;
	}

	public double thirdSkill() {
		double damage = baseDamage * 0.5 * physicalDamageCoefficient();
		System.out.println("�˺�Ϊ��"+ damage);
		return damage;
	}

	public double fourthSkill() {
		damage = baseDamage * 1.2 * (critDamage + 1);
		System.out.println("�˺�Ϊ��"+ damage);
		return damage;
	}
	
	public double fifthSkill() {
		damage = baseDamage * 0.3 * (critDamage +1);
		System.out.println("�˺�Ϊ��"+ damage);
		return damage;
	}
	
//	public double sixthSkill() {
//		damage = baseDamage * 2.7 * (critDamage +1);
//		System.out.println("�˺�Ϊ��"+ damage);
//		return damage;
//	}

	public double skillCast() {
		double damage = 0;
		int baseSkill = (int) (Math.random() * 5);
		
		switch (baseSkill) {
		case 0:
			System.out.println("*********������1����*********");
			damage += firstSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������2����*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������3����*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������4����*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������5����*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������6����*********");
//				damage += sixthSkill();
//			}
			break;
		case 1:
			System.out.println("*********������2����*********");
			damage += secondSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������1����*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������3����*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������4����*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������5����*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������6����*********");
//				damage += sixthSkill();
//			}
			break;
		case 2:
			System.out.println("*********������3����*********");
			damage += thirdSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������1����*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������2����*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������4����*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������5����*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������6����*********");
//				damage += sixthSkill();
//			}
			break;
		case 3:
			System.out.println("*********������4����*********");
			damage += fourthSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������1����*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������2����*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������3����*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������5����*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������6����*********");
//				damage += sixthSkill();
//			}
			break;
		case 4:
			System.out.println("*********������5����*********");
			damage += fifthSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������1����*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������2����*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������3����*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********������4����*********");
				damage += fourthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������6����*********");
//				damage += sixthSkill();
//			}
			break;
//		case 5:
//			System.out.println("*********������6����*********");
//			damage += sixthSkill();
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������1����*********");
//				damage += firstSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������2����*********");
//				damage += secondSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������3����*********");
//				damage += thirdSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������4����*********");
//				damage += fourthSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********������5����*********");
//				damage += fifthSkill();
//			}
//			break;
		}
		return damage;
	}
}
