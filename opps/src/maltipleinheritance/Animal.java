package maltipleinheritance;

import java.awt.Dialog;

public class Animal extends Mammal implements Dog,Cat {
 public  void cat()
 {
	 System.out.println("cat is pet");
 }
 public void dog()
 {
	 System.out.println("dog is pet");
 }
{
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Animal am=new Animal();
am.cat();
am.dog();
am.mammal();
	}

}
