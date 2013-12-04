/**
 * 控制台输出程序入口，主要用来对结果进行处理后输出
 */
import java.util.ArrayList;
public class main {
	 public static ArrayList<String> dataArray = new ArrayList<String> ();
	 public static ArrayList<String> dikaerResult = new ArrayList<String> (); //进行笛卡积后的结果
	 public static ArrayList<String> dikaerResultcut = new ArrayList<String> (); //进行笛卡积后再进行截取的结果
	 public static ArrayList<String> dikaerResultpl = new ArrayList<String> (); //盘路筛选后的结果
	 public static int cutlength=11;  //截取后要保留的位数
	 public static String[] str1 = { "3","1","0"};
	 public static String[] str2 = { "3"};
	 public static String[] str3 = { "3", "1", "0" };
	 public static String[] str4 = { "3", "1", "0" };
	 public static String[] str5 = { "3"};
	 public static String[] str6 = { "3"};
	 public static String[] str7 = { "3", "1", "0" };
	 public static String[] str8 = { "3", "1", "0" };
	 public static String[] str9 = { "3","1","0"};
	 public static String[] str10 = { "3", "1", "0" };
	 public static String[] str11 = { "3", "1", "0" };
	 public static String[] str12 = { "3"};
	 public static String[] str13 = { "3"};
	 public static String[] str14 = { "3" };
	public static void main(String[] args)
	{
		//MyDatas md=new MyDatas();
		//dataArray=md.ReadDatas("/Users/app/Desktop/APP/r8/src/result.txt"); 
		//System.out.println("读取完毕，已将"+dataArray.size()+"条结果存入dataArray中："+dataArray);
		//md.CutResult(1, 5);
		//for(int i=1;i<=14;i++)
		//{
			//md.zongxiang(i, 4,true);
			//md.zongxiang(i, 4,false);
		//}
		
		//Integer[] args1={1,2,3,4,5};
		//md.CustomResult(args1);
		
		/*
		 * 进行笛卡尔积
		 */
	    dikaerji dk=new dikaerji();
	    dk.str1=str1;
	    dk.str2=str2;
	    dk.str3=str3;
	    dk.str4=str4;
	    dk.str5=str5;
	    dk.str6=str6;
	    dk.str7=str7;
	    dk.str8=str8;
	    dk.str9=str9;
	    dk.str10=str10;
	    dk.str11=str11;
	    dk.str12=str12;
	    dk.str13=str13;
	    dk.str14=str14;
		dk.dikaerji(dikaerResult);
		for(int i=0;i<dikaerResult.size();i++)
		{
			dikaerResultcut.add(dikaerResult.get(i).substring(0, cutlength));
			
			
		}
		
		
		System.out.println(dikaerResultcut);
		System.out.println(dikaerResultcut.size());
		//盘路判断
		for(int j=0;j<dikaerResultcut.size();j++)
		{
			int pl=0;
			//第一场
			if(dikaerResultcut.get(j).substring(0, 1).equals("3"))
			{
				pl++;
			}
			//第二场
			if(dikaerResultcut.get(j).substring(1, 2).equals("3"))
			{
				pl++;
			}
			//第三场
			if(dikaerResultcut.get(j).substring(2, 3).equals("3"))
			{
				pl++;
			}
			//第四场
			if(dikaerResultcut.get(j).substring(3, 4).equals("3"))
			{
				pl++;
			}
			//第五场
			if(dikaerResultcut.get(j).substring(4, 5).equals("3"))
			{
				pl++;
			}
			//第六场
			if(dikaerResultcut.get(j).substring(5, 6).equals("3"))
			{
				pl++;
			}
			//第七场
			if(dikaerResultcut.get(j).substring(6, 7).equals("3"))
			{
				pl++;
			}
			//第八场
			if(dikaerResultcut.get(j).substring(7, 8).equals("3"))
			{
				pl++;
			}
			//第九场
			if(dikaerResultcut.get(j).substring(8, 9).equals("3"))
			{
				pl++;
			}
			//第十场
			if(dikaerResultcut.get(j).substring(9, 10).equals("3"))
			{
				pl++;
			}
			//第十一场
			if(dikaerResultcut.get(j).substring(10, 11).equals("3"))
			{
				pl++;
			}
			if(pl>=3&&pl<=6)
			{
				dikaerResultpl.add(dikaerResultcut.get(j));
			}
		}
		System.out.println(dikaerResultpl);
		System.out.println(dikaerResultpl.size());
	}
	

}
