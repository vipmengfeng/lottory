/**
 * ����̨���������ڣ���Ҫ�����Խ�����д�������
 */
import java.util.ArrayList;
public class mainApp {
	 public static ArrayList<String> dataArray = new ArrayList<String> ();//�����ԭʼ����
	 public static ArrayList<String> cutdataArray = new ArrayList<String> ();//��ȡԭʼ���ݺ�
	 public static ArrayList<String> dikaerResult = new ArrayList<String> (); //���еѿ�����Ľ��
	 public static ArrayList<String> dikaerResultcut = new ArrayList<String> (); //���еѿ������ٽ��н�ȡ�Ľ��
	 public static ArrayList<String> dikaerResultpl = new ArrayList<String> (); //ɸѡ��Ľ��
	 public static ArrayList<String> RESULTlist = new ArrayList<String> (); //���Ľ��
	 public static String[] str1 = { "1","0"};
	 public static String[] str2 = { "3","0"};
	 public static String[] str3 = { "3" };
	 public static String[] str4 = { "3"};
	 public static String[] str5 = { "0"};
	 public static String[] str6 = { "3"};
	 public static String[] str7 = { "1", "0" };
	 public static String[] str8 = { "3"};
	 public static String[] str9 = { "3","1"};
	 public static String[] str10 = {"0" };
	 public static String[] str11 = { "3", "1"};
	 public static String[] str12 = { "3"};
	 public static String[] str13 = { "1","0"};
	 public static String[] str14 = { "3","1","0"};
	 static MyDatas  md=new MyDatas();
	 static Integer arg[]={1,2,3,4,5,6,7,8,9};//Ҫ��ȡ����������
	public static void main(String[] args)
	{
		
		dataArray=md.ReadDatas("/Users/app/result.txt");
		md.print("��ȡԭʼ������ϣ��ѽ�"+dataArray.size()+"���������dataArray�У�"+dataArray);
		md.print("��ʼ���ɽ�ȡ");
		cutdataArray=md.CustomResult(arg,dataArray);
		int customresultNum=arg.length;
		md.print("���ɽ�ȡ��ϣ�����ȡ��"+customresultNum+"������");
		md.Contrast_array(cutdataArray);
		
		for(int i=0;i<cutdataArray.size()-1;i++)
		{
			int samenumber=0;
			for(int j=1;j<=customresultNum;j++)
			{
				if(md.cutNumber(cutdataArray.get(i),j).equals(md.cutNumber(cutdataArray.get(i+1),j)))
				{
					samenumber++;
				}
			}
			md.print("����һ����ȣ�����    {   "+samenumber+"    }   ������ͬ�Ľ��");
		}
		
		
		
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
		dk.dikaerjistart(dikaerResult);
		md.print(dikaerResult.size());
		dikaerResultcut=md.CustomResult(arg, dikaerResult);
		start(dikaerResultcut,cutdataArray.get(0),5);
		start(dikaerResultcut,cutdataArray.get(0),4);
		printResult();
	//main��������	
	}
	/**
	 * ��list�е�����������str���жԱȣ�str��list��ÿ��������num����ͬʱ���£����򲻱���
	 * @param list Ҫ�Աȵ�arraylist
	 * @param str  Ҫ�Ա�str
	 * @param num ��ͬ����
	 */
 private static void start(ArrayList<String> list,String str,int num)
 {
	 //String str2=md.CustomResult(arg, str);
	 int count=arg.length;
	 for(int i=0;i<list.size()-1;i++)
		{
			int samenumber=0;
			for(int j=1;j<=count;j++)
			{
				if(md.cutNumber(list.get(i),j).equals(md.cutNumber(str,j)))
				{
					samenumber++;
				}
			}
			
			if(samenumber==num)
			{
				dikaerResultpl.add(list.get(i));
			}
			
			
		}
	 //ȥ������ʷ�ظ��Ľ��
	 for(int i=0;i<dikaerResultpl.size();i++)
	 {
		 int counts=0;
		 for(int j=0;j<cutdataArray.size();j++)
		 {
			 if(dikaerResultpl.get(i).equals(cutdataArray.get(j)))
			 {
				 counts++;
			 }
		 }
		 if(counts==0)
		 {
			 if(dikaerResultpl.get(i).contains("1"))
			{
				 RESULTlist.add(dikaerResultpl.get(i));
		 	}
		 }
	 }
 }
 //��ӡ���ս��
 private static void printResult()
 {
	 md.print("����"+RESULTlist.size()+"����������:");
	 for(int i=0;i<RESULTlist.size();i++)
	 {
		 md.print(RESULTlist.get(i));
	 }
 }
}
