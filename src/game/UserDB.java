package game;
import game.User;
public class UserDB {
  public static User[] UserArray=new User[100];
  public static void queryuser(String Name){
	  User match=new User();
	  for(int i=1;i<count;i++)
	  {
		  if(UserArray[i].Name.equals(Name)){
			  match=UserArray[i];
			  System.out.println("�b��:"+match.Name);
			  System.out.println("�s��:"+match.UserNO);
			  System.out.println("�ثe�֦�����:"+match.Money);
			  System.out.println("-----------------");
		  }
	  }
	  if(match.Name==""){
		  System.out.println("�d�ߤ��즹�b����!");
		  System.out.println("-----------------");
	  }
  }
  public static void AllUser(){
	  for(int i=1;i<count;i++)
	  {
		      System.out.println("-----------------");
			  System.out.println("�b��:"+UserArray[i].Name);
			  System.out.println("�s��:"+UserArray[i].UserNO);
			  System.out.println("�ثe�֦�����:"+UserArray[i].Money);
			  System.out.println("-----------------");
		  }
	  }
  
  public static void record(){
	  User []record=new User[count];
	  for(int i=1;i<count;i++){
	  record[i]=UserArray[i];
	  }
	  int max=record[1].Money;
	  int j = 1;
	  for(int i=1;i<count;i++){
		  if(record[i].Money>max){
			  max=record[i].Money;
			  j=i;
		  }
	  }
	  System.out.println("�ˡˡˡˡˡˡˡˡˡˡˡˡˡˡˡˡ�");
	  System.out.println("�ثe�֦��̦h$$���Ʀ�]�a�x��:"+record[j].Name);
	  System.out.println("�L�֦�"+max+"��!!!");
	  System.out.println("�ˡˡˡˡˡˡˡˡˡˡˡˡˡˡˡˡ�");
	  
  }
  public static int count=3;
  public static void saveuser(User user){
	UserArray[count]=user;
	UserArray[count].UserNO=String.format("%04d",count);
	System.out.println("---�H�U���z���b����---");
	System.out.println("�z���b����:"+UserArray[count].Name);
	System.out.println("�z���K�X��:"+UserArray[count].Password);
	System.out.println("�z�������Ҭ�:"+UserArray[count].ID);
	System.out.println("�z���s����:"+UserArray[count].UserNO);
	System.out.println("���߱z��o���y�w�X:"+UserArray[count].Money);
	System.out.println("-----------------------");
	count++;
}
  public static User logon(String name,String password){
	  int a=0;
	  for(int i=1;i<count;i++){
		  if(UserArray[i].Name.equals(name)&&UserArray[i].Password.equals(password)){
			  System.out.println(name+" �z���\�n�J!");
			  System.out.println("-----------------");
			  a=i;
			  Main.check=true;
		  }
	  }
	  return UserArray[a];

  }

}
