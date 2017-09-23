package game;
import java.util.Scanner;
public class Main {
	public static User a=new User();
    public static double multi=1;
    public static void MainScreen(){
		Scanner scn=new Scanner(System.in);
		int ans=3;
		do{
			System.out.println("請選擇1.註冊新帳號 2.登入已有帳號 3.離開 0.管理員登入");
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
				System.out.println("管理員0號 登入成功!");
				GMScreen();
			}
	}while(ans!=3);
	}
	public static void UserScreen(){
		Scanner scn=new Scanner(System.in);
		int ans=3;
		do{
			System.out.println("您目前擁有:"+a.Money+"元");
			System.out.println("請選擇1.進行遊戲 2.查詢排行榜 3.登出");
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
			System.out.println("請選擇1.查看所有玩家名單  2.查詢單一玩家 3.修改遊戲倍率 4.登出");
			ans=scn.nextInt();
			if(ans==1){
				UserDB.AllUser();
			}
			else if(ans==2){
				String name;
				System.out.println("請輸入要查詢的玩家帳號");
				name=scn.next();
				UserDB.queryuser(name);
			}
			else if(ans==3){
				double q;
				do{
				System.out.println("請輸入倍率要修改到多少  (注意! 倍率最高不可超過1:3)");
				q=scn.nextDouble();
				if(q<=3){
					multi=q;
				}
				else{
					System.out.println("你輸入的倍率超過3了喔!!");
				}
				}while (q>3);
				System.out.println("倍率成功調至"+q+"倍");
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
		System.out.println("您好，這裡是註冊系統");
		System.out.println("請輸入您的帳號:");
		n.Name=scn.next();
		System.out.println("請輸入您的密碼:");
		n.Password=scn.next();
		System.out.println("請輸入您的身分證字號:");
		n.ID=scn.next();
		UserDB.saveuser(n);

	}
	static User log=new User();
	static boolean check;
	public static boolean GMcheck(){
		check=false;
		String name,password;
		Scanner scn=new Scanner(System.in);
		System.out.println("您好，這裡是※管理員※登入系統");
		System.out.println("請輸入您的帳號:");
		name=scn.next();
		System.out.println("請輸入您的密碼:");
		password=scn.next();
		if(name.equals(GM.ID)&&password.equals(GM.Password)){
			check=true;
		}
		while(check==false){
			System.out.println("抱歉，帳號或密碼輸入錯誤!");
			System.out.println("請重新輸入您的帳號:");
			name=scn.next();
			System.out.println("請重新輸入您的密碼:");
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
		System.out.println("您好，這裡是※使用者※登入系統");
		System.out.println("請輸入您的帳號:");
		name=scn.next();
		System.out.println("請輸入您的密碼:");
		password=scn.next();
		log=UserDB.logon(name, password);
		while(check==false){
			System.out.println("抱歉，帳號或密碼輸入錯誤!");
			System.out.println("請重新輸入您的帳號:");
			name=scn.next();
			System.out.println("請重新輸入您的密碼:");
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
		System.out.println("請問您要下注多少元? (注意:不可下注超過目前您所擁有的金錢數量!)");
		howmuch=scn.nextInt();
		if(howmuch>a.Money&&howmuch>0){
			System.out.println("您的金錢不足，請重新下注!");
		  }
		}while(howmuch>a.Money);
		System.out.println("目前賠率為1:"+multi);
		System.out.println("您下注了:"+howmuch+"元");
		System.out.println("GAME START!");
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("您的第"+(st+1)+"張牌為:");
		if(GameCard[st].Point=="10"){
			System.out.println("—------");
			System.out.println("│ "+GameCard[st].Color+" │");
			System.out.println("│     │");
			System.out.println("│  "+GameCard[st].Point+" │");
			System.out.println("│     │");
			System.out.println("—------");
			System.out.println("");
		}
		else{
		System.out.println("—------");
		System.out.println("│ "+GameCard[st].Color+" │");
		System.out.println("│     │");
		System.out.println("│  "+GameCard[st].Point+"  │");
		System.out.println("│     │");
		System.out.println("—------");
		System.out.println("");
		}
		totalnum+=GameCard[0].Num;
		st++;
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("您的第"+(st+1)+"張牌為:");
		if(GameCard[st].Point=="10"){
			System.out.println("—------");
			System.out.println("│ "+GameCard[st].Color+" │");
			System.out.println("│     │");
			System.out.println("│  "+GameCard[st].Point+" │");
			System.out.println("│     │");
			System.out.println("—------");
			System.out.println("");
		}
		else{
		System.out.println("—------");
		System.out.println("│ "+GameCard[st].Color+" │");
		System.out.println("│     │");
		System.out.println("│  "+GameCard[st].Point+"  │");
		System.out.println("│     │");
		System.out.println("—------");
		System.out.println("");
		}
		totalnum+=GameCard[1].Num;
		st++;
		if(totalnum>21){
			System.out.println("您目前的點數為:"+totalnum);
			System.out.println("BOOM!!! 你的點數超過21點囉，你輸了哦^+^");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		if(totalnum==21){
			System.out.println("你運氣真好，剛剛好21點  You win!");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
		do{
			System.out.println("1.再一張牌 2.不需要了");
			ans=scn.nextInt();
			if(ans==1){
				System.out.println("您的第"+(st+1)+"張牌為:");
				if(GameCard[st].Point=="10"){
					System.out.println("—------");
					System.out.println("│ "+GameCard[st].Color+" │");
					System.out.println("│     │");
					System.out.println("│  "+GameCard[st].Point+" │");
					System.out.println("│     │");
					System.out.println("—------");
					System.out.println("");
				}
				else{
				System.out.println("—------");
				System.out.println("│ "+GameCard[st].Color+" │");
				System.out.println("│     │");
				System.out.println("│  "+GameCard[st].Point+"  │");
				System.out.println("│     │");
				System.out.println("—------");
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
			System.out.println("Wow!你擁有5張牌且點數沒超過21點，恭喜你成功過5關!!");
			System.out.println("《系統獎勵》 過5關倍率自動乘以兩倍!!");
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
			System.out.println("您目前的點數為:"+totalnum);
			System.out.println("BOOM!!! 你的點數超過21點囉，你輸了哦^+^");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		else if(totalnum==21){
			System.out.println("你真強，剛剛好21點 You win!");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
			else{
				System.out.println("那就輪到莊家囉!");
				try{Thread.sleep(1000);}catch(Exception e){}
				System.out.println("-----------------");
			}
		System.out.println("莊家的第"+(st2+1)+"張牌為:");
		if(GameCard[st].Point=="10"){
			System.out.println("—------");
			System.out.println("│ "+GameCard[st].Color+" │");
			System.out.println("│     │");
			System.out.println("│  "+GameCard[st].Point+" │");
			System.out.println("│     │");
			System.out.println("—------");
			System.out.println("");
		}
		else{
		System.out.println("—------");
		System.out.println("│ "+GameCard[st].Color+" │");
		System.out.println("│     │");
		System.out.println("│  "+GameCard[st].Point+"  │");
		System.out.println("│     │");
		System.out.println("—------");
		System.out.println("");
		}
		System.out.println("");
		totalnum2+=GameCard[st].Num;
		st++;
		st2++;
		try{Thread.sleep(500);}catch(Exception e){}
		System.out.println("莊家的第"+(st2+1)+"張牌為:");
		if(GameCard[st].Point=="10"){
			System.out.println("—------");
			System.out.println("│ "+GameCard[st].Color+" │");
			System.out.println("│     │");
			System.out.println("│  "+GameCard[st].Point+" │");
			System.out.println("│     │");
			System.out.println("—------");
			System.out.println("");
		}
		else{
		System.out.println("—------");
		System.out.println("│ "+GameCard[st].Color+" │");
		System.out.println("│     │");
		System.out.println("│  "+GameCard[st].Point+"  │");
		System.out.println("│     │");
		System.out.println("—------");
		System.out.println("");
		}
		System.out.println("");
		totalnum2+=GameCard[st].Num;
		if(totalnum2==21){
			System.out.println("我運氣真好，剛剛好21點  抱歉囉>.<");
			a.Money=a.Money-howmuch;
			System.out.println("-----------------");
			return;
		}
		st++;
		st2++;
		do{
			if(st2==5){
				System.out.println("我過5關囉~所以你輸了@_@");
				a.Money=a.Money-howmuch;
				return;
			}
			try{Thread.sleep(1000);}catch(Exception e){}
			System.out.print("讓我思考一下...");
			try{Thread.sleep(500);}catch(Exception e){}
			System.out.print("讓我思考一下");
			System.out.println(".....");		
			if((totalnum2<17)&&totalnum2-totalnum+GameCard[0].Num<=4){
				try{Thread.sleep(500);}catch(Exception e){}
					System.out.println("莊家的第"+(st2+1)+"張牌為:");
					if(GameCard[st].Point=="10"){
						System.out.println("—------");
						System.out.println("│ "+GameCard[st].Color+" │");
						System.out.println("│     │");
						System.out.println("│  "+GameCard[st].Point+" │");
						System.out.println("│     │");
						System.out.println("—------");
						System.out.println("");
					}
					else{
					System.out.println("—------");
					System.out.println("│ "+GameCard[st].Color+" │");
					System.out.println("│     │");
					System.out.println("│  "+GameCard[st].Point+"  │");
					System.out.println("│     │");
					System.out.println("—------");
					System.out.println("");
					}
					totalnum2+=GameCard[st].Num;
					st++;
					st2++;
				
			}
			else if((totalnum2==17||totalnum2==18)&&totalnum2-totalnum+GameCard[0].Num<=2){
				try{Thread.sleep(500);}catch(Exception e){}
				System.out.println("莊家的第"+(st2+1)+"張牌為:");
				if(GameCard[st].Point=="10"){
					System.out.println("—------");
					System.out.println("│ "+GameCard[st].Color+" │");
					System.out.println("│     │");
					System.out.println("│  "+GameCard[st].Point+" │");
					System.out.println("│     │");
					System.out.println("—------");
					System.out.println("");
				}
				else{
				System.out.println("—------");
				System.out.println("│ "+GameCard[st].Color+" │");
				System.out.println("│     │");
				System.out.println("│  "+GameCard[st].Point+"  │");
				System.out.println("│     │");
				System.out.println("—------");
				System.out.println("");
				}
				totalnum2+=GameCard[st].Num;
				st++;
				st2++;
			}
			else if(totalnum2<=16){
				try{Thread.sleep(500);}catch(Exception e){}
				System.out.println("莊家的第"+(st2+1)+"張牌為:");
				if(GameCard[st].Point=="10"){
					System.out.println("—------");
					System.out.println("│ "+GameCard[st].Color+" │");
					System.out.println("│     │");
					System.out.println("│  "+GameCard[st].Point+" │");
					System.out.println("│     │");
					System.out.println("—------");
					System.out.println("");
				}
				else{
				System.out.println("—------");
				System.out.println("│ "+GameCard[st].Color+" │");
				System.out.println("│     │");
				System.out.println("│  "+GameCard[st].Point+"  │");
				System.out.println("│     │");
				System.out.println("—------");
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
			System.out.println("哎呀! 我的牌爆掉了，你贏了(￣▽￣) ");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
			return;
		}
		System.out.println("開牌! 來比點數大小吧!");
		try{Thread.sleep(300);}catch(Exception e){}
		System.out.println("你的點數為:"+totalnum);
		System.out.println("莊家的點數為:"+totalnum2);
		try{Thread.sleep(500);}catch(Exception e){}
		if(totalnum2>totalnum){
			if(totalnum2!=21){
			a.Money=a.Money-howmuch;
			System.out.println("我的牌比你還大 ，你輸了呦╮(╯◇╰)╭");
			System.out.println("-----------------");
		}
			else{
				
				System.out.println("我運氣真好，剛好21點~~");
				System.out.println("抱歉你輸了喔O_O");
				a.Money=a.Money-howmuch;
				System.out.println("-----------------");
			}
		}
		else if(totalnum2==totalnum){
			a.Money=a.Money-howmuch;
			System.out.println("雖然點數相同，不過我是莊家，可惜了 請再接再厲(=￣ω￣=)");
			System.out.println("-----------------");
		}
		else{
			System.out.println("你贏了!! 歡迎再次下注╭(﹊∩∩﹊)╮");
			a.Money=(int) (a.Money+(howmuch*multi));
			System.out.println("-----------------");
		}
	}

	
		private static User GM=new User();
		public static void main(String[] args) {
			UserDB.UserArray[1]=new User();
			UserDB.UserArray[2]=new User();
			UserDB.UserArray[1].Name="廖小賀";
			UserDB.UserArray[1].UserNO=String.format("%04d",1);
			UserDB.UserArray[1].Money=99999;
			UserDB.UserArray[2].Name="隔壁老王";
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

