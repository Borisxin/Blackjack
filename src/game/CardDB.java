package game;

public class CardDB {
	public static Card[] poker=new Card[52];
	
	CardDB(){
		String []point=new String[]{"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String []color=new String[]{"¶Â®ç","¬õ¤ß","µÙ§Î","±öªá"};
		int[] number=new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};
		for(int i=0;i<52;i++){
			poker[i]=new Card();
			if(i<13){
				poker[i].Color=color[0];
				poker[i].Point=point[i];
				poker[i].Num=number[i];
			}
			else if((i<26)&&(i>=13)){
				poker[i].Color=color[1];
				poker[i].Point=point[i-13];
				poker[i].Num=number[i-13];
			}
			else if((i>=26)&&(i<39)){
				poker[i].Color=color[2];
				poker[i].Point=point[i-26];
				poker[i].Num=number[i-26];
			}
			else{
				poker[i].Color=color[3];
				poker[i].Point=point[i-39];
				poker[i].Num=number[i-39];
			}
				
		}
		
	}

	public static Card[] GetCard(){
		new CardDB();
		Card []play=new Card[10];
		int i=0;
		A:while(i<10){
		int t=(int)(Math.random()*(51-0)+0+1);
		for(int j=0;j<i;j++){
			if(play[j]==poker[t])
				continue A;
		}
		play[i]=poker[t];
		i++;
		}
		
		return play;
	}

}
