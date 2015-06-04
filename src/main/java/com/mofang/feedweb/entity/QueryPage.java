/**
 * 
 */
package com.mofang.feedweb.entity;

/**
 * @author daisyli
 * 
 */
public class QueryPage {

	private int currPageNum = 1;

	private int num;

	private int pageSize;

	private int total;

	private int totalPageNum;

	private int start;

	private int end;

	private int[] pageBar;

	/**
	 * 
	 * @param currPageNum
	 * @param pageSize
	 * @param total
	 */
	public QueryPage(int currPageNum, int pageSize, int total) {
		if (pageSize < 1) {
			pageSize = 10;
		}
		if (total < 1) {
			total = 0;
		}
		if (currPageNum < 1) {
			currPageNum = 1;
		}

		this.total = total;
		this.pageSize = pageSize;
		this.totalPageNum = (total + pageSize - 1) / pageSize;
		// FIX:防止搜索结果数为0时分页的数字出现0
		if (total == 0) {
			this.totalPageNum = 1;
		}

		// 最后一页
		if (currPageNum * pageSize >= total) {
			currPageNum = totalPageNum;
			this.num = ((total - 1) % pageSize) + 1;
		} else {
			this.num = pageSize;
		}
		this.currPageNum = currPageNum;
		if (currPageNum < 1) {
			this.start = 0;
		} else {
			this.start = pageSize * (currPageNum - 1);
		}
		this.end = Math.min(total, this.start + this.num);
	}

	/**
	 * 当前页的实际结果数量
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 获取当前页数据在mysql中的limit分页的start参数值（该值从0开始）
	 * 
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 获得当前页结尾的后面一位在整体结果列表中的位置(列表总个数，或者下一页的起点位置)
	 * 
	 * @return
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * 当前结果是第几页，有结果的页码从1开始，无结果的页码为0
	 * 
	 * @return
	 */
	public int getCurrPageNum() {
		return currPageNum;
	}

	/**
	 * 每页的最大结果数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 总共的结果数量
	 * 
	 * @return
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * 结果的总页数
	 * 
	 * @return
	 */
	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int[] getPagebar() {

		// 当总页数小于十条时
		if (this.totalPageNum <= 10) {
			this.pageBar = new int[this.totalPageNum];
			for (int i = 1; i <= this.totalPageNum; i++) {
				this.pageBar[i - 1] = i;
			}
			return pageBar;
		}
		// 大于十条
		int startpage = this.currPageNum - 4;
		int endpage = this.currPageNum + 5;

		if (startpage < 1) {
			startpage = 1;
			endpage = 10;
		}
		if (endpage > this.totalPageNum) {
			endpage = this.totalPageNum;
			startpage = this.totalPageNum - 9;
		}
		this.pageBar = new int[10];
		int index = 0;
		for (int i = startpage; i <= endpage; i++) {
			this.pageBar[index++] = i;
		}
		return pageBar;
	}

	public static void main(String[] args) {
		QueryPage page = new QueryPage(6, 20, 1500);
		System.out.println("totalPage:" + page.getTotalPageNum());
		int[] pageBar = page.getPagebar();
		for (int pageNum : pageBar) {

			System.out.print(pageNum + ",");
		}
	}

}
