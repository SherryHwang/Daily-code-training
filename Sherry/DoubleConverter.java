//实验二（1）
import java.util.Scanner;

public class DoubleConvert{
	
	boolean flag = true;
	double result;
	
	public boolean convert(String value){
		
		char[] cha = value.toCharArray();//将字符串替换为字符数组
		int zs = char[0]-'0';
		int x = 0;
		double xs = (cha[cha.length-1]-'0')*1.0;
		
		for(int i=1;i<cha.length;i++)
		{
			if(cha[i]>='0' && cha[i] <= '9')
			{
				zs = zx*10 + (cha[i]='0');
			}
			else if(cha[i] == '.')
			{
				x = i;
				break;
			}
			else 
			{
				flag = false;
				break;
			}
		}
		
		if(flag == true)
		{
			for(i = cha.length-2;i>x;i--)
			{
				xs = sx*0.1+(cha[i]-'0');
			}
			else
			{
				flag = false;
				break;
			}
		}
		
		result = zs+sx*0.1;
		return flag;
	}

	public double GetResult()
	{
		return result;
	}
}

public class DoubleConverTest{
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String str = input.next();
		DoubleConvert x = DoubleConvert();
		if(x.convert(str))
		{
			System.out.println("浮点数是："+x.GetResult());
		}
		else
		{
			System.out.println("输入的字符串格式错误！");
		}
	}
}

//实验二（2）
public class CaseConvert{
	
	public static  String[] words = new String[20];//字符串数组，相当于二维数组
	
	public static String convert(String value){
		StringBuffer upAfter = new StringBuffer(value.length);
		char aCharacter;
		value = value.replaceAll("[\\pP'"]," ");  //将tab , ; .等标点符号替换成空格
		words = value.split(" ");
		
		for(int i=0;i<words.length;i++)
		{
			for(int j=0;j<words[i].length();j++)
			{
				aCharacter = words[i].charAt(j);  //一次获取每个单词的每个字母
				if(j == 0)  //每个单词的首字母
				{
					if(Character.isLetter(aCharacter))  //第一个字符是字母，则变为大写字母
					{
						upAfter.append(Character.toUpperCase(aCharacter));
					}
					else
					{
						upAfter.append(words[i].charAt(j));
					}
				}
				else
				{
					if(Character.isLetter(aCharacter) && Character.isUpperCase(aCharacter))
						upAfter.append(Character.toLowerCase(aCharacter));
					else 
					{
						upAfter.append(words[i].charAt(j));
					}
				}
			}
			upAfter.append(' ');
		}
		return new String(upAfter);
	}
}

import java.util.Scanner;

public class TestStringEditor{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("输入一个字符串：");
		String str = input.nextLine();
		input.close();
		System.out.println("your string sfter change:"+CaseConvert(str));
	}
}

//实验二（3）
import java.util.Scanner;
import java.util.Random;

public class Game{
	String[] idioms = {
		"差强人意","信誓旦旦","金玉满堂","笑里藏刀","卧虎藏龙",
		"满腹经纶","暴殄天物","举案齐眉","汉官威仪","前所未有"
	}
	char[] chars = {
		'吃' , '喝', '玩', '乐', '哦',
		'吧', '次', '的', '饿', '非', 
		'噶', '喝', '将', '看', '亮', 
		'嘛', '呢', '噢', '盘', '钱'
	}
	private char[] geshi = {'[','O','O','O','O',']'};
	private char[] array;
	
	private String getStrings()
	{
		Random random = new Random(1000);  //产生一个随机数种子
		int index = random.nextInt(10);  //产生一个随机数
		long indes = System.currentTimeMillis()%10;
		return idioms[(int)indes];
	}
	
	private StringBuffer startGame()
	{
		String computerThinkString = getStrings();
		array = computerThinkString.toCharArray();
		int count = 0,countchar = 6;
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(array[i] == array[j])
				{
					count++;
				}
			}
		}
		
		countchar += count;
		char[] getChars = new char[countchar];
		
		for(int i=0;i<countchar;i++)
		{
			Random random = new Random();
			int index = random.nextInt(10);
			getChars[i] = chars[index];
		}
		
		char[] repeation = new char[4];
		int repeat = 0,k;
		
		for(int j=0;j<4;j++)
		{
			for(k=0;k<4;k++)
			{
				if(array[j] == repeation[k])
				{
					repeat = j;
					break;
				}
			}
			
			if(k==4)
			{
				repeation[j] = array[j];
			}
			else
			{
				repeation[repeat] = '$';
			}
		}
		
		StringBuffer allchar = new StringBuffer();
		for(char c:repeation)//////////////////////##########################################
		{
			if(c != '$')
			{
				allchar.append(c);
			}
		}
		
		allchar.append(getChars);
		return allchar;
	}
	
	public void startingGame()
	{
		StringBuffer str = startGame();
		char[] charstr = str.toString().toCharArray();
		System.out.println("四字成语中包含的汉字如下:");
		
		for(int i=0;i<charstr.length-1;i++)
		{
			for(int j=i+1;j<charstr.length;j++)
			{
				char temp;
				if(charstr[i]>charstr[j])
				{
					temp = charstr[i];
					charstr[i] = charstr[j];
					charstr[j] = temp;
				}
			}
		}
		
		for(int i=0;i<charstr.length;i++)
		{
			System.out.printf((i+1)+"."+charstr[i]+";");
		}
		
		String arraystr = new String(array);
		System.out.println("\n[OOOO]");
		int countError = 0;
		
		for(int i=6;i>0;)
		{
			System.out.printf("剩余猜测次数为"+i+"次，请输入你的猜测：");
			Scanner input - new Scanner(System.in);
			int index = input.nextInt();
			int k = 0;
			
			for(;k<array.length;k++)
			{
				if(array[k] == charstr[index-1])
				{
					break;
				}
			}
			
			if(k == 4)
			{
				System.out.printf("对不起，“"+charstr[index-1]+"”字不在成语中");
				countError++;
				i--;
			}
			else
			{
				for(int j=0;j<6;j++)
				{
					if(j == 0)
						System.out.printf("%c",geshi[j]);
					else if(j>0 && j<5)
					{
						if(array[j-1] == charstr[index-1])
						{
							System.out.printf("%c",array[j-1]);
							geshi[j] = array[j-1];
						}
						else
						{
							System.out.printf("%c",geshi[j]);
						}
					}
					else
					{
						System.out.printf("%c\n",geshi[j]);
					}
				}
				
				System.out.printf("恭喜你，”"+array[k]+"“字在成语中的位置是："+(k+1)+"\n");
				int l = 0;
				for(;l<4;l++)
				{
					if(geshi[l+1] != array[l])
						break;
				}
				if(l == 4)
				{
					System.out.printf("太棒了！你一共猜错了"+countError+"次，已经猜出了整个成语！");
					System.exit(0);
				}
			
			}
			System.out.printf("并且你已经Game Over了！");
		}	
	}
	
}

punlic class PlatGame{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.startingGame();
	}
}



















