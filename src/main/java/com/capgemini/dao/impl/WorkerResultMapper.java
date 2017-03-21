package com.capgemini.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capgemini.domain.Worker;

public class WorkerResultMapper implements RowMapper<Worker>{
		@Override
		public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
			Worker w = new Worker();
			w.setName(rs.getString("name"));
			w.setName(rs.getString("surname"));
			return w;
		}

}
