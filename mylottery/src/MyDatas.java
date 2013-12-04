import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * �������ı��б�������ݣ�ĿǰΪֹ���Ѿ�ʵ�ֺ������������������ַ�����
 * @ReadDatas(String src) �����ⲿtxt�ļ�����
 * @CutResult(int s_count,int e_count) �����ȡ���ݽ��з���
 * @zongxiang(int zs_count,int zr_length,boolean lx) �����ȡ���ݽ��з���
 * @author ��
 * @since 2013.5.14
 */

public class MyDatas {
	private int frame_x=-300;
	private int frame_y=20;
	private  ArrayList<String> dataArray = new ArrayList<String> ();
	private  ArrayList<String> cutArray = new ArrayList<String> ();
	private  ArrayList<String> zongArray = new ArrayList<String> ();
	private  ArrayList<String> zongResult = new ArrayList<String> ();
	private  ArrayList<String> zongResults = new ArrayList<String> ();
	private  ArrayList<String> customCut = new ArrayList<String> ();
	/**
	 * ��ȡtxt��ʽ�Ľ����������ArrayList
	 * @param src Ҫ��ȡ���ı�·�����ļ���������չ��.txt��
	 * @return ArrayList<String>
	 */
	public ArrayList<String> ReadDatas(String src)
	{
		dataArray.clear();
		cutArray.clear();
		zongResult.clear();
		zongResults.clear();
		customCut.clear();
		try
        {
         File f2=new File(src); 
         BufferedReader bfr2=new BufferedReader(new FileReader(f2));
         String str2=bfr2.readLine();
         while(str2!=null)
            {
        	 	dataArray.add(str2);
            	str2 = bfr2.readLine();
            }
         bfr2.close(); 
        }catch(IOException f2){}
		return dataArray;
	}
	/**
	 * �����ȡ����
	 * @param s_count ��ȡ��ʼλ��
	 * @param e_count ��ȡ����λ��
	 * @return ArrayList
	 */
	public ArrayList<String> CutResult(int s_count,int e_count)
	{
		if(s_count<1)
		{
			s_count=1;
			System.out.println("��ʼλ����������Ѿ�������λ������Ϊ��С��1λ");
		}
		if(e_count>14)
		{
			e_count=14;
			System.out.println("������������Ѿ�������λ������Ϊ���14λ");
		}
		for(int i=0;i<dataArray.size();i++)
        {
			cutArray.add(dataArray.get(i).substring((s_count-1), e_count));
        }
		int xt_count=CutRes(cutArray);
        System.out.println("��ȡ���Ʊ�������ϣ���ȡ��λ��Ϊ��"+s_count+"��"+e_count+"λ���ѽ��������cutArray�С�");
        System.out.println("cutArrayΪ��"+cutArray);
        if(xt_count!=0){
        	System.out.println("ע������ͬ�������ͬ�ܴ���Ϊ��"+xt_count+"��.");
        }
		return cutArray;
	}
	/**
	 * �����ȡ��������
	 * @param zs_count �ڼ���
	 * @param zr_length ��ϳ���
	 * @param lx �Ƿ��������
	 * @throws InterruptedException 
	 */
	public  void zongxiang(int zs_count,int zr_length,boolean lx)

	{
		String strs="";
		if(zs_count>14)
		{
			zs_count=14;
			//System.out.println("����������Ѿ�������λ������Ϊ���14��");
		}
		for(int i=0;i<dataArray.size();i++)
        {
			zongArray.add(dataArray.get(i).substring(zs_count-1, zs_count));
        }
		//System.out.println("��ȡ�ڣ�"+zs_count+"�н��бȽϡ��ܼ���Ϊ��"+zongArray);
		
		for(int i=0;i<zongArray.size();i++)
		{
			strs+=zongArray.get(i);
		}
		//System.out.println("���кϲ���Ϊ��"+strs);
		showWindows(strs,zs_count,zr_length,"3",lx);
		showWindows(strs,zs_count,zr_length,"1",lx);
		showWindows(strs,zs_count,zr_length,"0",lx);
		zongArray.clear();
		
	}
	/**
	 * �Զ����к���������±Ƚ�
	 * @param args �������Զ���������϶��ɵ�Integer����
	 */
	public void CustomResult(Integer[] args)
	{
		String customstr="";
		ArrayList<String> customArray = new ArrayList<String> ();
		
		for(int j=0;j<dataArray.size();j++)
		{
			customstr="";
			for(int i=0;i<args.length;i++)
			{
				customstr+=dataArray.get(j).substring((args[i]-1), args[i]);
			}
			customCut.add(customstr);
		}
		CutRes(customCut);
	}
	/**
	 * ��ȡ���ݺ���
	 * @param AL ����Ҫ��ȡ�Ľ����
	 * @return
	 */
	private int CutRes(ArrayList<String> AL)
	{
        int xt_count=0;
        for(int i=0;i<AL.size()-1;i++)
        {
        	for(int k=i+1;k<AL.size();k++)
        	{
        		if(AL.get(i).equals(AL.get(k)))
        		{
        			
        			xt_count++;
        			System.out.println(i+1+"---"+(k+1)+"---��ֵ="+(k-i));
        			break;
        		}
        	}
        }
        return xt_count;
	}
	/**
	 * ��ʾС����
	 * @param strs �ϲ�����ַ���
	 * @param zs_count �ڼ���
	 * @param zr_length ��ϳ���
	 * @param res ������
	 * @param bl �Ƿ�����
	 * @throws InterruptedException
	 */
	private void showWindows(String strs,int zs_count,int zr_length,String res,boolean bl)
	{
		if(frame_x<900)
		{
			frame_x+=400;
		}else
		{
			frame_x=100;
			frame_y+=20;
		}
		String strRes=strs.replace("*", res);
		if(bl)
		{
			for(int i=0;i<strRes.length()-zr_length;i++)
			{
				zongResults.add(strRes.substring(i, i+zr_length));
			}
		}
		else
		{
			for(int i=0;i<strRes.length()-zr_length;i=i+zr_length)//�������Ƚ�
			{
				zongResults.add(strRes.substring(i, i+zr_length));
			}
		}
			
		
		for(int i=0;i<zongResults.size();i++)
		{
			for(int j=i+1;j<zongResults.size();j++)
			{
				if(zongResults.get(i).equals(zongResults.get(j)))
				{
					zongResult.add("              "+(i+1)+"---"+(j+1)+"---��ֵ="+(j-i)+"   "+zongResults.get(i));
        			break;
				}
			}
		}
		//����С������ʾ
		MyJframe mj=new MyJframe();
		if(bl)
		{
			mj.run(zongResult,"��"+zs_count+"��Ϊ"+res+"ʱ(����"+zr_length+"��)",frame_x,frame_y);
		}
		else
		{
			mj.run(zongResult,"��"+zs_count+"��Ϊ"+res+"ʱ(������"+zr_length+"��))",frame_x,frame_y);
		}
		
		zongResults.clear();
		zongResult.clear();
		strRes="";
	}
}
