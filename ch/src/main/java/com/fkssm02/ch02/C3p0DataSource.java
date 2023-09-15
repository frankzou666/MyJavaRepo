package com.fkssm02.ch02;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0DataSource extends UnpooledDataSourceFactory{
	
	 public C3p0DataSource() {
		 this.dataSource = new ComboPooledDataSource();
	 }

}
