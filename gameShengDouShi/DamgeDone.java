package gameShengDouShi;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DamgeDone {

	public static void main(String[] args){
		double damage;
		double totalDamage = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��������˺���");
		Hero.setBaseDamage(sc.nextDouble());

		System.out.println("���뱩���ȼ���");
		Hero.setProbCrit(sc.nextDouble());

		System.out.println("���뱩���˺���");
		Hero.setCritDamage(sc.nextDouble());

		sc.close();
		
		
		LiuGuaiShou myLGS = new LiuGuaiShou();
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("/---------------------��" + (i + 1) + "��ģ��---------------------/");
			damage = myLGS.skillCast();
			totalDamage += damage;
		}
		System.out.println("���˺�Ϊ��"+ df.format(totalDamage));
		System.out.println("ƽ���˺�Ϊ��"+ df.format(totalDamage/100000+Hero.baseDamage * 0.8 * Hero.physicalDamageCoefficient()));
		System.out.println("���: "+ df.format((totalDamage/100000+Hero.baseDamage * 0.8 * Hero.physicalDamageCoefficient())/Hero.baseDamage*100) +"%");
		
		
		
	}

}
