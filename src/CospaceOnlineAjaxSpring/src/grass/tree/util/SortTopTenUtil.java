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
//		// 排序后的列表
//		List sortedList = null;
//		
//		// 临时排序表
//		List tmpSortList = new ArrayList();
//		// 临时无排序表
//		List tmpNonSortNeededList = new ArrayList();
//		// 将排序前的列表抽出
//		for (int i=0;i<randomList.size();i++){
//			Blogmaster randomBlog = (Blogmaster)randomList.get(i);
//			// 当序号部位0的时候，放入堆中
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
////		// 赋值
//		sortedList = tmpSortList;
		//System.out.println("size:"+sortedList.size());
		return randomList;
	}
}
