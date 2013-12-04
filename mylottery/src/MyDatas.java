import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 分析在文本中保存的数据，目前为止，已经实现横向分析与纵向分析两种方法。
 * @ReadDatas(String src) 加载外部txt文件数据
 * @CutResult(int s_count,int e_count) 横向截取数据进行分析
 * @zongxiang(int zs_count,int zr_length,boolean lx) 纵向截取数据进行分析
 * @author 孟
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
	 * 读取txt格式的结果集，返回ArrayList
	 * @param src 要读取的文本路径及文件名（带扩展名.txt）
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
	 * 横向截取数据
	 * @param s_count 截取开始位置
	 * @param e_count 截取结束位置
	 * @return ArrayList
	 */
	public ArrayList<String> CutResult(int s_count,int e_count)
	{
		if(s_count<1)
		{
			s_count=1;
			System.out.println("开始位置输入错误，已经将结束位置设置为最小：1位");
		}
		if(e_count>14)
		{
			e_count=14;
			System.out.println("结束输入错误，已经将结束位置设置为最大：14位");
		}
		for(int i=0;i<dataArray.size();i++)
        {
			cutArray.add(dataArray.get(i).substring((s_count-1), e_count));
        }
		int xt_count=CutRes(cutArray);
        System.out.println("截取走势表数据完毕，截取的位数为："+s_count+"至"+e_count+"位，已将结果存入cutArray中。");
        System.out.println("cutArray为："+cutArray);
        if(xt_count!=0){
        	System.out.println("注意有相同结果，相同总次数为："+xt_count+"次.");
        }
		return cutArray;
	}
	/**
	 * 纵向截取分析数据
	 * @param zs_count 第几列
	 * @param zr_length 组合长度
	 * @param lx 是否连续组合
	 * @throws InterruptedException 
	 */
	public  void zongxiang(int zs_count,int zr_length,boolean lx)

	{
		String strs="";
		if(zs_count>14)
		{
			zs_count=14;
			//System.out.println("列输入错误，已经将结束位置设置为最大：14列");
		}
		for(int i=0;i<dataArray.size();i++)
        {
			zongArray.add(dataArray.get(i).substring(zs_count-1, zs_count));
        }
		//System.out.println("提取第："+zs_count+"列进行比较。总集合为："+zongArray);
		
		for(int i=0;i<zongArray.size();i++)
		{
			strs+=zongArray.get(i);
		}
		//System.out.println("进行合并后为："+strs);
		showWindows(strs,zs_count,zr_length,"3",lx);
		showWindows(strs,zs_count,zr_length,"1",lx);
		showWindows(strs,zs_count,zr_length,"0",lx);
		zongArray.clear();
		
	}
	/**
	 * 自定义列横向组合向下比较
	 * @param args 传入由自定义列数组合而成的Integer数组
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
	 * 截取数据函数
	 * @param AL 传入要截取的结果集
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
        			System.out.println(i+1+"---"+(k+1)+"---差值="+(k-i));
        			break;
        		}
        	}
        }
        return xt_count;
	}
	/**
	 * 显示小窗口
	 * @param strs 合并后的字符串
	 * @param zs_count 第几列
	 * @param zr_length 组合长度
	 * @param res 替代结果
	 * @param bl 是否连续
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
			for(int i=0;i<strRes.length()-zr_length;i=i+zr_length)//非连续比较
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
					zongResult.add("              "+(i+1)+"---"+(j+1)+"---差值="+(j-i)+"   "+zongResults.get(i));
        			break;
				}
			}
		}
		//创建小窗口显示
		MyJframe mj=new MyJframe();
		if(bl)
		{
			mj.run(zongResult,"第"+zs_count+"场为"+res+"时(连续"+zr_length+"轮)",frame_x,frame_y);
		}
		else
		{
			mj.run(zongResult,"第"+zs_count+"场为"+res+"时(非连续"+zr_length+"轮))",frame_x,frame_y);
		}
		
		zongResults.clear();
		zongResult.clear();
		strRes="";
	}
}
