package com.el.ecom.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.el.ecom.query.Sort.Direction;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = -5585754500805674524L;

	private List<T> content = new ArrayList<>();

	private final long total;

	private final Pageable pageable;

	public Page() {
		this.total = 0L;
		this.pageable = new Pageable();
	}

	public Page(List<T> content, long total, Pageable pageable) {
		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	public int getPageNumber() {
		return this.pageable.getPageNumber();
	}

	public int getPageSize() {
		return this.pageable.getPageSize();
	}

	public String getSearchProperty() {
		return pageable.getSearchProperty();
	}

	public String getSearchValue() {
		return pageable.getSearchValue();
	}

	public String getSortProperty() {
		return pageable.getSortProperty();
	}

	public Direction getSortDirection() {
		return pageable.getSortDirection();
	}

	public List<Sort> getSorts() {
		return pageable.getSorts();
	}

	public List<Filter> getFilters() {
		return pageable.getFilters();
	}

	public List<T> getContent() {
		return content;
	}

	public long getTotal() {
		return total;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public int getTotalPages() {
		return (int) Math.ceil(getTotal() / getPageSize());
	}

	public static final <T> Page<T> emptyPage(Pageable pageable) {
		return new Page<T>(Collections.<T> emptyList(), 0L, pageable);
	}
}
