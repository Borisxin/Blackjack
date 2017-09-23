package game;
import java.util.Scanner;
public class Main {
	public static User a=new User();
    public static double multi=1;
    public static void MainScreen(){
		Scanner scn=new Scanner(System.in);
		int ans=3;
		do{
			System.out.println("�п��1.���U�s�b�� 2.�n�J�w���b�� 3.���} 0.�޲z���n�J");
			ans=scn.nextInt();
			if(ans==1){
				register();
			}
			else if(ans==2){
				a=logon();
				UserScreen();
			}
			else if(ans==3){
				System.exit(0);  
			}
			else if(ans==0){
				GMcheck();
				System.out.println("�޲z��0�� �n�J���\!");
				GMScreen();
			}
	}while(ans!=3);
	}
	public static void UserScreen(){
		Scanner scn=new Scanner(System.in);
		int ans=3;
		do{
			System.out.println("�z�ثe�֦�:"+a.Money+"��");
			System.out.println("�п��1.�i��C�� 2.�d�߱Ʀ�] 3.�n�X");
			ans=scn.nextInt();
			if(ans==1){
				Game();
			}
			else if(ans==2){
				UserDB.record();
			}
			else if(ans==3){
				MainScreen();
			}
		}while(ans!=3);
	}
	public static void GMScreen(){
		Scanner scn=new Scanner(System.in);
		int ans=3;
		do{
			System.out.println("�п��1.�d�ݩҦ����a�W��  2.�d�߳�@���a 3.�ק�C�����v 4.�n�X");
			ans=scn.nextInt();
			if(ans==1){
				UserDB.AllUser();
			}
			else if(ans==2){
				String name;
				System.out.println("�п�J�n�d�ߪ����a�b��");
				name=scn.next();
				UserDB.queryuser(name);
			}
			else if(ans==3){
				double q;
				do{
				System.out.println("�п�J���v�n�ק��h��  (�`�N! ���v�̰����i�W�L1:3)");
				q=scn.nextDouble();
				if(q<=3){
					multi=q;
				}
				else{
					System.out.println("�A��J�����v�W�L3�F��!!");
				}
				}while (q>3);
				System.out.println("���v���\�զ�"+q+"��");
				System.out.println("-----------------");
			}
			else if(ans==4){
				MainScreen();
			}
		}while(ans!=4);
	}
	
	public static void register(){
		User n=new User();
		Scanner scn=new Scanner(System.in);
		System.out.println("�z�n�A�o�̬O���U�t��");
		System.out.println("�п�J�z���b��:");
		n.Name=scn.next();
		System.out.println("�п�J�z���K�X:");
		n.Password=scn.next();
		System.out.println("�п�J�z�������Ҧr��:");
		n.ID=scn.next();
		UserDB.saveuser(n);

	}
	static User log=new User();
	static boolean check;
	public static boolean GMcheck(){
		check=false;
		String name,password;
		Scanner scn=new Scanner(System.in);
		System.out.println("�z�n�A�o�̬O���޲z�����n�J�t��");
		System.out.println("�п�J�z���b��:");
		name=scn.next();
		System.out.println("�п�J�z���K�X:");
		password=scn.next();
		if(name.equals(GM.ID)&&password.equals(GM.Password)){
			check=true;
		}
		while(check==false){
			System.out.println("��p�A�b���αK�X��J���~!");
			System.out.println("�Э��s��J�z���b��:");
			name=scn.next();
			System.out.println("�Э��s��J�z���K�X:");
			password=scn.next();
			if(name.equals(GM.ID)&&password.equals(GM.Password)){
				check=true;
			}
		}
		return check;
	}
	public static User logon(){
		check=false;
		String name,password;
		Scanner scn=new Scanner(System.in);
		System.out.println("�z�n�A�o�̬O���ϥΪ̡��n�J�t��");
		System.out.println("�п�J�z���b��:");
		name=scn.next();
		System.out.println("�п�J�z���K�X:");
		password=scn.next();
		log=UserDB.logon(name, password);
		while(check==false){
			System.out.println("��p�A�b���αK�X��J���~!");
			System.out.println("�Э��s��J�z���b��:");
			name=scn.next();
			System.out.println("�Э��s��J�z���K�X:");
			password=scn.next();
			log=UserDB.logon(name, password);
		}
		return log;
	}
	public static void Game(){
		Scanner scn=new Scanner(System.in);
		int howmuch,st=0,st2=0,ans,totalnum=0,totalnum2=0;
		Card[] GameCard=new Card[10];
		GameCard=CardDB.GetCard();
		do{
		System.out.println("�аݱz�n�U�`�h�֤�? (�`�N:���i�U�`�W�L�ثe�z�Ҿ֦��������ƶq!)");
		howmuch=scn.nextInt();
		if(howmuch>a.Money&&howmuch>0){
			System.out.println("�z�����������A�Э��s�U�`!");
		  }
		}while(howmuch>a.Money);
		System.out.println("�ثe�߲v��1:"+multi);
		System.out.println("�z�U�`�F:"+howmuch+"��");
		System.out.println("GAME START!");
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("�z����"+(st+1)+"�i�P��:");
		if(GameCard[st].Point=="10"){
			System.out.println("�X------");
			System.out.println("�x "+GameCard[st].Color+" �x");
			System.out.println("�x     �x");
			System.out.println("�x  "+GameCard[st].Point+" �x");
			System.out.println("�x     �x");
			System.out.println("�X------");
			System.out.println("");
		}
		else{
		System.out.println("�X------");
		System.out.println("�x "+GameCard[st].Color+" �x");
		System.out.println("�x     �x");
		System.out.println("�x  "+GameCard[st].Point+"  �x");
		System.out.println("�x     �x");
		System.out.println("�X------");
		System.out.println("");
		}
		totalnum+=GameCard[0].Num;
		st++;
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("�z����"+(st+1)+"�i�P��:");
		if(GameCard[st].Point=="10"){
			System.out.println("�X------");
			System.out.println("�x "+GameCard[st].Color+" �x");
			System.out.println("�x     �x");
			System.out.println("�x  "+GameCard[st].Point+" �x");
			System.out.println("�x     �x");
			System.out.println("�X------");
			System.out.println("");
		}
		else{
		System.out.println("�X------");
		System.out.println("�x "+GameCard[st].Color+" �x");
		System.out.println("�x     �x");
		System.out.println("�x  "+GameCard[st].Point+"  �x");
		System.out.println("�x     �x");
		System.out.println("�X------");
		System.out.println("");
		}
		totalnum+=GameCard[1].Num;
		st++;
		if(totalnum>21){
			System.out.println("�z�ثe���I�Ƭ�:"+totalnum);
			System.out.println("BOOM!!! �A���I�ƶW�L21�I�o�A�A��F�@^+^");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		if(totalnum==21){
			System.out.println("�A�B��u�n�A���n21�I  You win!");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
		do{
			System.out.println("1.�A�@�i�P 2.���ݭn�F");
			ans=scn.nextInt();
			if(ans==1){
				System.out.println("�z����"+(st+1)+"�i�P��:");
				if(GameCard[st].Point=="10"){
					System.out.println("�X------");
					System.out.println("�x "+GameCard[st].Color+" �x");
					System.out.println("�x     �x");
					System.out.println("�x  "+GameCard[st].Point+" �x");
					System.out.println("�x     �x");
					System.out.println("�X------");
					System.out.println("");
				}
				else{
				System.out.println("�X------");
				System.out.println("�x "+GameCard[st].Color+" �x");
				System.out.println("�x     �x");
				System.out.println("�x  "+GameCard[st].Point+"  �x");
				System.out.println("�x     �x");
				System.out.println("�X------");
				System.out.println("");
				}
				totalnum+=GameCard[st].Num;
				st++;
			}
			else{
				continue;
			}
		}while(ans==1&&st<=4&&totalnum<21);
		if(st>4&&totalnum<=21){
			System.out.println("Wow!�A�֦�5�i�P�B�I�ƨS�W�L21�I�A���ߧA���\�L5��!!");
			System.out.println("�m�t�μ��y�n �L5�����v�۰ʭ��H�⭿!!");
			a.Money=(int) (a.Money+(howmuch*multi*2));
			System.out.println("-----------------");
			return;
		}
		for(int i=0;i<st;i++){
			if(GameCard[i].Num==1){
				if((totalnum+10)<=21)
					totalnum=totalnum+10;
			}
		}
		if(totalnum>21){
			System.out.println("�z�ثe���I�Ƭ�:"+totalnum);
			System.out.println("BOOM!!! �A���I�ƶW�L21�I�o�A�A��F�@^+^");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		else if(totalnum==21){
			System.out.println("�A�u�j�A���n21�I You win!");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
			else{
				System.out.println("���N������a�o!");
				try{Thread.sleep(1000);}catch(Exception e){}
				System.out.println("-----------------");
			}
		System.out.println("���a����"+(st2+1)+"�i�P��:");
		if(GameCard[st].Point=="10"){
			System.out.println("�X------");
			System.out.println("�x "+GameCard[st].Color+" �x");
			System.out.println("�x     �x");
			System.out.println("�x  "+GameCard[st].Point+" �x");
			System.out.println("�x     �x");
			System.out.println("�X------");
			System.out.println("");
		}
		else{
		System.out.println("�X------");
		System.out.println("�x "+GameCard[st].Color+" �x");
		System.out.println("�x     �x");
		System.out.println("�x  "+GameCard[st].Point+"  �x");
		System.out.println("�x     �x");
		System.out.println("�X------");
		System.out.println("");
		}
		System.out.println("");
		totalnum2+=GameCard[st].Num;
		st++;
		st2++;
		try{Thread.sleep(500);}catch(Exception e){}
		System.out.println("���a����"+(st2+1)+"�i�P��:");
		if(GameCard[st].Point=="10"){
			System.out.println("�X------");
			System.out.println("�x "+GameCard[st].Color+" �x");
			System.out.println("�x     �x");
			System.out.println("�x  "+GameCard[st].Point+" �x");
			System.out.println("�x     �x");
			System.out.println("�X------");
			System.out.println("");
		}
		else{
		System.out.println("�X------");
		System.out.println("�x "+GameCard[st].Color+" �x");
		System.out.println("�x     �x");
		System.out.println("�x  "+GameCard[st].Point+"  �x");
		System.out.println("�x     �x");
		System.out.println("�X------");
		System.out.println("");
		}
		System.out.println("");
		totalnum2+=GameCard[st].Num;
		if(totalnum2==21){
			System.out.println("�ڹB��u�n�A���n21�I  ��p�o>.<");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		st++;
		st2++;
		do{
			if(st2==5){
				System.out.println("�ڹL5���o~�ҥH�A��F@_@");
				a.Money=a.Money-howmuch;
				return;
			}
			try{Thread.sleep(1000);}catch(Exception e){}
			System.out.print("���ګ�Ҥ@�U...");
			try{Thread.sleep(500);}catch(Exception e){}
			System.out.print("���ګ�Ҥ@�U");
			System.out.println(".....");		
			if((totalnum2<17)&&totalnum2-totalnum+GameCard[0].Num<=4){
				try{Thread.sleep(500);}catch(Exception e){}
					System.out.println("���a����"+(st2+1)+"�i�P��:");
					if(GameCard[st].Point=="10"){
						System.out.println("�X------");
						System.out.println("�x "+GameCard[st].Color+" �x");
						System.out.println("�x     �x");
						System.out.println("�x  "+GameCard[st].Point+" �x");
						System.out.println("�x     �x");
						System.out.println("�X------");
						System.out.println("");
					}
					else{
					System.out.println("�X------");
					System.out.println("�x "+GameCard[st].Color+" �x");
					System.out.println("�x     �x");
					System.out.println("�x  "+GameCard[st].Point+"  �x");
					System.out.println("�x     �x");
					System.out.println("�X------");
					System.out.println("");
					}
					totalnum2+=GameCard[st].Num;
					st++;
					st2++;
				
			}
			else if((totalnum2==17||totalnum2==18)&&totalnum2-totalnum+GameCard[0].Num<=2){
				try{Thread.sleep(500);}catch(Exception e){}
				System.out.println("���a����"+(st2+1)+"�i�P��:");
				if(GameCard[st].Point=="10"){
					System.out.println("�X------");
					System.out.println("�x "+GameCard[st].Color+" �x");
					System.out.println("�x     �x");
					System.out.println("�x  "+GameCard[st].Point+" �x");
					System.out.println("�x     �x");
					System.out.println("�X------");
					System.out.println("");
				}
				else{
				System.out.println("�X------");
				System.out.println("�x "+GameCard[st].Color+" �x");
				System.out.println("�x     �x");
				System.out.println("�x  "+GameCard[st].Point+"  �x");
				System.out.println("�x     �x");
				System.out.println("�X------");
				System.out.println("");
				}
				totalnum2+=GameCard[st].Num;
				st++;
				st2++;
			}
			else if(totalnum2<=16){
				try{Thread.sleep(500);}catch(Exception e){}
				System.out.println("���a����"+(st2+1)+"�i�P��:");
				if(GameCard[st].Point=="10"){
					System.out.println("�X------");
					System.out.println("�x "+GameCard[st].Color+" �x");
					System.out.println("�x     �x");
					System.out.println("�x  "+GameCard[st].Point+" �x");
					System.out.println("�x     �x");
					System.out.println("�X------");
					System.out.println("");
				}
				else{
				System.out.println("�X------");
				System.out.println("�x "+GameCard[st].Color+" �x");
				System.out.println("�x     �x");
				System.out.println("�x  "+GameCard[st].Point+"  �x");
				System.out.println("�x     �x");
				System.out.println("�X------");
				System.out.println("");
				}
				totalnum2+=GameCard[st].Num;
				st++;
				st2++;
			}
		
			else if(totalnum2>=17){
				continue;
			}
			
			else{
				continue ;
			}
		}while(totalnum2<16);
		
		if(totalnum2>21){
			System.out.println("�u�r! �ڪ��P�z���F�A�AĹ�F(�á���) ");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
		System.out.println("�}�P! �Ӥ��I�Ƥj�p�a!");
		try{Thread.sleep(300);}catch(Exception e){}
		System.out.println("�A���I�Ƭ�:"+totalnum);
		System.out.println("���a���I�Ƭ�:"+totalnum2);
		try{Thread.sleep(500);}catch(Exception e){}
		if(totalnum2>totalnum){
			if(totalnum2!=21){
			a.Money=a.Money-howmuch;
			System.out.println("�ڪ��P��A�٤j �A�A��F�碡(������)�~");
			System.out.println("-----------------");
		}
			else{
				
				System.out.println("�ڹB��u�n�A��n21�I~~");
				System.out.println("��p�A��F��O_O");
				a.Money=a.Money-howmuch;
				System.out.println("-----------------");
			}
		}
		else if(totalnum2==totalnum){
			a.Money=a.Money-howmuch;
			System.out.println("���M�I�ƬۦP�A���L�ڬO���a�A�i���F �ЦA���A�F(=�ãs��=)");
			System.out.println("-----------------");
		}
		else{
			System.out.println("�AĹ�F!! �w��A���U�`�~(�ǡ���)��");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
		}
	}

	
		private static User GM=new User();
		public static void main(String[] args) {
			UserDB.UserArray[1]=new User();
			UserDB.UserArray[2]=new User();
			UserDB.UserArray[1].Name="���p�P";
			UserDB.UserArray[1].UserNO=String.format("%04d",1);
			UserDB.UserArray[1].Money=99999;
			UserDB.UserArray[2].Name="�j���Ѥ�";
			UserDB.UserArray[2].UserNO=String.format("%04d",2);
		    UserDB.UserArray[2].Money=25000;
			  GM.ID="0000";
			  GM.Money=9999999;
			  GM.Name="0000";
			  GM.Password="123";
			  GM.UserNO="0000";
			MainScreen();
			return;
		}
}

