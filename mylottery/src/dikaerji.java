
import java.util.ArrayList;
import java.util.List;
/**
 * ���Ƚ�eclipse��run config ��������Ϊ-Xmx1000M
 * �ѿ����� �࣬ʹ�÷���dikaerji������ArrayList���򽫼�������䴫���ArrayList
 * Ĭ��str1��str14��Ϊ��310
 * @author ��
 *
 */
public class dikaerji {
	 public String[] str1 = { "3", "1", "0" };
	 public String[] str2 = { "3", "1", "0" };
	 public String[] str3 = { "3", "1", "0" };
	 public String[] str4 = { "3", "1", "0" };
	 public String[] str5 = { "3", "1", "0" };
	 public String[] str6 = { "3", "1", "0" };
	 public String[] str7 = { "3", "1", "0" };
	 public String[] str8 = { "3", "1", "0" };
	 public String[] str9 = { "3", "1", "0" };
	 public String[] str10 = { "3", "1", "0" };
	 public String[] str11 = { "3", "1", "0" };
	 public String[] str12 = { "3", "1", "0" };
	 public String[] str13 = { "3", "1", "0" };
	 public String[] str14 = { "3", "1", "0" };
	 /**
	  * �ѿ��������㷽��
	  * @param result
	  */
 public void dikaerji (List<String> result) {
  List<String[]> list = new ArrayList<String[]>();
  list.add(str1);
  list.add(str2);
  list.add(str3);
  list.add(str4);
  list.add(str5);
  list.add(str6);
  list.add(str7);
  list.add(str8);
  list.add(str9);
  list.add(str10);
  list.add(str11);
  list.add(str12);
  list.add(str13);
  list.add(str14);
  Descartes(list, 0, result, "");
   
 }
 private  String Descartes(List<String[]> list, int count,
   List<String> result, String data) {
  String temp = data;
  // ��ȡ��ǰ����
  String[] astr = list.get(count);
  // ѭ����ǰ����
  // foreach (var item in astr)
  for (int i = 0; i < astr.length; i++) {
   if (count + 1 < list.size()) {
    temp += Descartes(list, count + 1, result, data + astr[i]);
   } else {
    result.add(data + astr[i]);
   }
  }
  return temp;
 }
}


