package grass.tree.util;

import grass.tree.hibernate.Blogmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTopTenUtil {
	public static List createTopList(List randomList){
		if (randomList == null){
			return null;
		}
//		// �������б�
//		List sortedList = null;
//		
//		// ��ʱ�����
//		List tmpSortList = new ArrayList();
//		// ��ʱ�������
//		List tmpNonSortNeededList = new ArrayList();
//		// ������ǰ���б���
//		for (int i=0;i<randomList.size();i++){
//			Blogmaster randomBlog = (Blogmaster)randomList.get(i);
//			// ����Ų�λ0��ʱ�򣬷������
//			if (randomBlog.getTopvalue()!=0){
//				tmpSortList.add(randomBlog);
//			}else{
//				tmpNonSortNeededList.add(randomBlog);
//			}
//		}
//		Collections.sort(tmpSortList);
		//Collections.sort(randomList);
//		tmpSortList.add(tmpNonSortNeededList);
//		
////		// ��ֵ
//		sortedList = tmpSortList;
		//System.out.println("size:"+sortedList.size());
		return randomList;
	}
}
