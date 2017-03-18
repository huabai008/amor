package com.amor.orm.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;

import com.amor.core.base.BaseModel;
import com.github.pagehelper.PageInfo;

@SuppressWarnings("serial")
public class PageForSolr<T> extends PageInfo<T> {

	public PageForSolr() {
		super();
	}

	private SolrQuery query = new SolrQuery();

	private String queryStr;

	private List<String> facetFields;

	private List<FacetField> facetResult;

	private List<Object> modelResult;

	Map<Integer, String> modelImages;

	public SolrQuery getQuery() {
		return query;
	}

	public void setQuery(SolrQuery query) {
		this.query = query;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public List<String> getFacetFields() {
		return facetFields;
	}

	public void addFacetField(String field) {
		if (this.facetFields == null)
			facetFields = new LinkedList<>();
		facetFields.add(field);
	}

	public List<FacetField> getFacetResult() {
		return facetResult;
	}

	public void setFacetResult(List<FacetField> facetResult) {
		this.facetResult = facetResult;
	}

	public List<Object> getModelResult() {
		return modelResult;
	}

	public void setModelResult(List<Object> modelResult) {
		this.modelResult = modelResult;
	}

	public void setModelImage(Integer id, String path) {
		if (this.modelImages == null) {
			modelImages = new HashMap<>();
		}
		modelImages.put(id, path);
	}

	public String getModelImage(Integer id) {
		return modelImages.get(id);
	}

	public Map<Integer, String> getModelImages() {
		return modelImages;
	}

	public void refrashPageNum() {
		int pages = (int) (getTotal() % getSize() == 0 ? getTotal() / getSize() : getTotal() / getSize() + 1);
		int[] navigatepageNums;
		if (pages <= 7) {
			navigatepageNums = new int[pages];
			for (int i = 0; i < pages; i++) {
				navigatepageNums[i] = i + 1;
			}
		} else {
			navigatepageNums = new int[7];
			int start = getPageNum() - 3;
			int end = getPageNum() + 3;
			if (start < 1) {
				start = 1;
				for (int i = 0; i < 7; i++) {
					navigatepageNums[i] = start++;
				}
			} else if (end > pages) {
				end = pages;
				for (int i = 6; i >= 0; i--) {
					navigatepageNums[i] = end--;
				}
			} else {
				for (int i = 0; i < 7; i++) {
					navigatepageNums[i] = start++;
				}
			}

		}
		setNavigatepageNums(navigatepageNums);
		if (getPageNum() > 1) {
			setPrePage(getPageNum() - 1);
		}
		if (getPageNum() < pages)
			setNextPage(getPageNum() + 1);
		setIsFirstPage(getPageNum() == 1);
		setIsLastPage(getPageNum() == pages);
		setHasPreviousPage(getPageNum() > 1);
		setHasNextPage(getPageNum() < pages);
	}

}
