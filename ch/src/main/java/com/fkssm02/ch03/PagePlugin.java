package com.fkssm02.ch03;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({ @Signature (type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}) })
public class PagePlugin implements Interceptor {

	@Override
	
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		String sqlStr;
		//得到statementHandler
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		System.out.println("this is plag####");
		//获取BoundSql对像
		BoundSql boundSql= statementHandler.getBoundSql();
		//输出SQL串
		sqlStr = boundSql.getSql();
		System.out.println(sqlStr);
		MetaObject metaObject = SystemMetaObject.forObject (statementHandler);
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		//输出ID
		System.out.println(mappedStatement.getId());
		//给语句增加了limit 1
		metaObject. setValue ("delegate.boundSql.sql", sqlStr + " limit 1") ;
		return invocation.proceed();
	}

}
