package gameShengDouShi;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DamgeDone {

	public static void main(String[] args){
		double damage;
		double totalDamage = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("输入基础伤害：");
		Hero.setBaseDamage(sc.nextDouble());

		System.out.println("输入暴击等级：");
		Hero.setProbCrit(sc.nextDouble());

		System.out.println("输入暴击伤害：");
		Hero.setCritDamage(sc.nextDouble());

		sc.close();
		
		
		LiuGuaiShou myLGS = new LiuGuaiShou();
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("/---------------------第" + (i + 1) + "次模拟---------------------/");
			damage = myLGS.skillCast();
			totalDamage += damage;
		}
		System.out.println("总伤害为："+ df.format(totalDamage));
		System.out.println("平均伤害为："+ df.format(totalDamage/100000+Hero.baseDamage * 0.8 * Hero.physicalDamageCoefficient()));
		System.out.println("造成: "+ df.format((totalDamage/100000+Hero.baseDamage * 0.8 * Hero.physicalDamageCoefficient())/Hero.baseDamage*100) +"%");
		
		
		
	}

}
