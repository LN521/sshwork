package com.dk.utils;

import java.util.List;

public class PageBean<T> {
	   private Integer startIndex;//��ʼλ��
	   private Integer pageNumber;//��ǰҳ��
	   private Integer pageSize;//ÿ��ҳ��
	   private Integer totalCount;//������
	   private Integer totalPage;//��ҳ��
	   private List<T> result;//�����
	public Integer getStartIndex() {
		//ͨ����ǰҳ��ÿҳ�������㿪ʼλ��
	   startIndex =(pageNumber-1)*pageSize;
	       return startIndex;
	}	
	public void setStartIndex(Integer startIndex) {
			this.startIndex = startIndex;
	}
	public Integer getPageNumber() {
			return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
			return pageSize;
	}	
	public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
			return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
			this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
			totalPage=getTotalCount() % getPageSize()==0? getTotalCount()/getPageSize() : getTotalCount()/getPageSize()+1;
		 
			return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(Integer startIndex, Integer pageNumber, Integer pageSize, Integer totalCount, Integer totalPage,
			List<T> result) {
		super();
		this.startIndex = startIndex;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.result = result;
	}
	@Override
	public String toString() {
		return "PageBean [startIndex=" + startIndex + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", result=" + result + "]";
	}
	   
} 
