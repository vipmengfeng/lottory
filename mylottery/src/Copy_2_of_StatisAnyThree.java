
import java.util.ArrayList;
import java.util.List;
/**
 * ͳ���������ֵ����ļ��ʵ����
 * 
 * @author ����
 * @date 2013-12-5����10:00:00
 */
public class Copy_2_of_StatisAnyThree {
//  ����㷨   
//    �������˼·�ǿ�һ�����飬���±��ʾ1��m����������Ԫ�ص�ֵΪ1��ʾ���±�   
//    ���������ѡ�У�Ϊ0��ûѡ�С�     
//    ���ȳ�ʼ����������ǰn��Ԫ����1����ʾ��һ�����Ϊǰn������     
//    Ȼ�������ɨ������Ԫ��ֵ�ġ�10����ϣ��ҵ���һ����10����Ϻ����Ϊ   
//    ��01����ϣ�ͬʱ������ߵ����С�1��ȫ���ƶ������������ˡ�     
//    ����һ����1���ƶ��������m-n��λ�ã���n����1��ȫ���ƶ������Ҷ�ʱ���͵�   
//    �������һ����ϡ�     
//    ������5��ѡ3����ϣ�     
//    1   1   1   0   0   //1,2,3     
//    1   1   0   1   0   //1,2,4     
//    1   0   1   1   0   //1,3,4     
//    0   1   1   1   0   //2,3,4     
//    1   1   0   0   1   //1,2,5     
//    1   0   1   0   1   //1,3,5     
//    0   1   1   0   1   //2,3,5     
//    1   0   0   1   1   //1,4,5     
//    0   1   0   1   1   //2,4,5     
//    0   0   1   1   1   //3,4,5   
    public static void main(String[] args) {
        Copy_2_of_StatisAnyThree s = new Copy_2_of_StatisAnyThree();
        s.printAnyThree();      
    }
    
    /**
     * 
     */
    public void printAnyThree(){
        int[] num = new int[]{1,2,3,4,5};
        print(combine(num,3));
    }
    /**
     * ��n��������ѡ��m������
     * @param a
     * @param m
     * @return
     */
    public List<int[]> combine(int[] a,int m){
        int n = a.length;
        if(m>n){
            System.out.println("��������a��ֻ��"+n+"��Ԫ�ء�"+m+"����"+2+"!!!");
        }
        
        List<int[]> result = new ArrayList<int[]>();
        
        int[] bs = new int[n];
        for(int i=0;i<n;i++){
            bs[i]=0;
        }
        //��ʼ��
        for(int i=0;i<m;i++){
            bs[i]=1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        //�����ҵ���һ��10��ϣ�Ȼ����01��ͬʱ��������е�1�ƶ�������������
        do{
            sum = 0;
            pos = 0;
            tempFlag = true; 
            result.add(print(bs,a,m));
            
            for(int i=0;i<n-1;i++){
                if(bs[i]==1 && bs[i+1]==0 ){
                    bs[i]=0;
                    bs[i+1]=1;
                    pos = i;
                    break;
                }
            }
            //����ߵ�1ȫ���ƶ�������������
            
            for(int i=0;i<pos;i++){
                if(bs[i]==1){
                    sum++;
                }
            }
            for(int i=0;i<pos;i++){
                if(i<sum){
                    bs[i]=1;
                }else{
                    bs[i]=0;
                }
            }
            
            //����Ƿ����е�1���ƶ��������ұ�
            for(int i= n-m;i<n;i++){
                if(bs[i]==0){
                    tempFlag = false;
                    break;
                }
            }
            if(tempFlag==false){
                flag = true;
            }else{
                flag = false;
            }
            
        }while(flag);
        result.add(print(bs,a,m));
        
        return result;
    }
    
    private int[] print(int[] bs,int[] a,int m){
        int[] result = new int[m];
        int pos= 0;
        for(int i=0;i<bs.length;i++){
            if(bs[i]==1){
                result[pos]=a[i];
                pos++;
            }
        }
        return result ;
    }
    
    private void print(List<int[]> l){
        for(int i=0;i<l.size();i++){
            int[] a = (int[])l.get(i);
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }
}
