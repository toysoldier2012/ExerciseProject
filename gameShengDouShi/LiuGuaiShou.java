package gameShengDouShi;
import java.text.DecimalFormat;

public class LiuGuaiShou extends Hero {
	double damage = 0;
	DecimalFormat df = new DecimalFormat("0.00");
	
	public double firstSkill() {
		damage = baseDamage * 0;
		System.out.println("伤害为："+ df.format(damage));
		return damage;
	}

	public double secondSkill() {
		damage = baseDamage * 1.2 * physicalDamageCoefficient() * 2.1164;
		System.out.println("伤害为："+ df.format(damage));
		return damage;
	}

	public double thirdSkill() {
		double damage = baseDamage * 0.5 * physicalDamageCoefficient();
		System.out.println("伤害为："+ damage);
		return damage;
	}

	public double fourthSkill() {
		damage = baseDamage * 1.2 * (critDamage + 1);
		System.out.println("伤害为："+ damage);
		return damage;
	}
	
	public double fifthSkill() {
		damage = baseDamage * 0.3 * (critDamage +1);
		System.out.println("伤害为："+ damage);
		return damage;
	}
	
//	public double sixthSkill() {
//		damage = baseDamage * 2.7 * (critDamage +1);
//		System.out.println("伤害为："+ damage);
//		return damage;
//	}

	public double skillCast() {
		double damage = 0;
		int baseSkill = (int) (Math.random() * 5);
		
		switch (baseSkill) {
		case 0:
			System.out.println("*********触发了1技能*********");
			damage += firstSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了2技能*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了3技能*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了4技能*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了5技能*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了6技能*********");
//				damage += sixthSkill();
//			}
			break;
		case 1:
			System.out.println("*********触发了2技能*********");
			damage += secondSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了1技能*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了3技能*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了4技能*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了5技能*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了6技能*********");
//				damage += sixthSkill();
//			}
			break;
		case 2:
			System.out.println("*********触发了3技能*********");
			damage += thirdSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了1技能*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了2技能*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了4技能*********");
				damage += fourthSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了5技能*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了6技能*********");
//				damage += sixthSkill();
//			}
			break;
		case 3:
			System.out.println("*********触发了4技能*********");
			damage += fourthSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了1技能*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了2技能*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了3技能*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了5技能*********");
				damage += fifthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了6技能*********");
//				damage += sixthSkill();
//			}
			break;
		case 4:
			System.out.println("*********触发了5技能*********");
			damage += fifthSkill();
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了1技能*********");
				damage += firstSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了2技能*********");
				damage += secondSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了3技能*********");
				damage += thirdSkill();
			}
			if((int) (Math.random() * 4) == 0) {
				System.out.println("*********触发了4技能*********");
				damage += fourthSkill();
			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了6技能*********");
//				damage += sixthSkill();
//			}
			break;
//		case 5:
//			System.out.println("*********触发了6技能*********");
//			damage += sixthSkill();
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了1技能*********");
//				damage += firstSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了2技能*********");
//				damage += secondSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了3技能*********");
//				damage += thirdSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了4技能*********");
//				damage += fourthSkill();
//			}
//			if((int) (Math.random() * 4) == 0) {
//				System.out.println("*********触发了5技能*********");
//				damage += fifthSkill();
//			}
//			break;
		}
		return damage;
	}
}
