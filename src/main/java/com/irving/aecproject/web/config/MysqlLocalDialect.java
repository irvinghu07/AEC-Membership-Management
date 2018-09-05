package com.irving.aecproject.web.config;

import org.hibernate.dialect.MySQL5Dialect;

public class MysqlLocalDialect extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
