package org.apache.ibatis.singledog.jpa.generator.impl;

import org.apache.ibatis.singledog.jpa.generator.MetaDataParser;
import org.apache.ibatis.singledog.jpa.meta.Column;
import org.apache.ibatis.singledog.jpa.meta.Table;
import org.w3c.dom.Element;

import java.util.Map;

/**
 * Created by Adam on 2017/7/3.
 */
public class FindByIdGeneratorImpl extends AbstractSqlGenerator {

    @Override
    public String generatorSql(MetaDataParser dataParser, Map<String, Object> params) {
        Table table = dataParser.getTable();
        Column id = table.getSingleIdColumn();
        StringBuilder select = new StringBuilder();
        select.append(" select ").append(table.getAllColumns()).append(" from ").append(table.getName())
                .append(" where ").append(id.getColumn()).append("=#{").append(id.getProperty()).append("}");
        return select(getMethod(params), id.getJavaType(), null, null, select.toString());
    }
}
