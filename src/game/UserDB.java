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
			  System.out.println("帳號:"+match.Name);
			  System.out.println("編號:"+match.UserNO);
			  System.out.println("目前擁有金錢:"+match.Money);
			  System.out.println("-----------------");
		  }
	  }
	  if(match.Name==""){
		  System.out.println("查詢不到此帳號喔!");
		  System.out.println("-----------------");
	  }
  }
  public static void AllUser(){
	  for(int i=1;i<count;i++)
	  {
		      System.out.println("-----------------");
			  System.out.println("帳號:"+UserArray[i].Name);
			  System.out.println("編號:"+UserArray[i].UserNO);
			  System.out.println("目前擁有金錢:"+UserArray[i].Money);
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
	  System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
	  System.out.println("目前擁有最多$$的排行榜冠軍為:"+record[j].Name);
	  System.out.println("他擁有"+max+"元!!!");
	  System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
	  
  }
  public static int count=3;
  public static void saveuser(User user){
	UserArray[count]=user;
	UserArray[count].UserNO=String.format("%04d",count);
	System.out.println("---以下為您的帳戶資料---");
	System.out.println("您的帳號為:"+UserArray[count].Name);
	System.out.println("您的密碼為:"+UserArray[count].Password);
	System.out.println("您的身分證為:"+UserArray[count].ID);
	System.out.println("您的編號為:"+UserArray[count].UserNO);
	System.out.println("恭喜您獲得獎勵籌碼:"+UserArray[count].Money);
	System.out.println("-----------------------");
	count++;
}
  public static User logon(String name,String password){
	  int a=0;
	  for(int i=1;i<count;i++){
		  if(UserArray[i].Name.equals(name)&&UserArray[i].Password.equals(password)){
			  System.out.println(name+" 您成功登入!");
			  System.out.println("-----------------");
			  a=i;
			  Main.check=true;
		  }
	  }
	  return UserArray[a];

  }

}
