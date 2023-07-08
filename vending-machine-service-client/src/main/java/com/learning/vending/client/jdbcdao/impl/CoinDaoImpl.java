package com.learning.vending.client.jdbcdao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.learning.vending.client.jdbcdao.CoinDao;
import com.learning.vending.client.metadata.CoinEnum;
import com.learning.vending.client.model.Coin;

public class CoinDaoImpl implements CoinDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Coin getCoin(CoinEnum coin, boolean forUpdate) {
		String sql = "select * from coins where name=?";
		
		if(forUpdate) {
			sql = sql+" FOR UPDATE";
		}
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Coin.class), coin.name());
	}

	@Override
	public int updateCoin(Coin coin) {
		return jdbcTemplate.update("UPDATE coins SET count = ? WHERE id = ?", coin.getCount(), coin.getId());
	}

	
	@Override
	public Map<CoinEnum, Coin> getCoins() {
		String sql = "select * from coins where count >0";

		return jdbcTemplate.query(sql, new CoinRowSetExtractor());
	}

	@Override
	public int[] updateCoins(List<Coin> coins) {
		String sql = "update coins set count = ? where id = ?";
		
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, coins.get(i).getCount());
				ps.setInt(2, coins.get(i).getId());
			}

			@Override
			public int getBatchSize() {
				return coins.size();
			}
			
		});
	}
	
	
	public class CoinRowSetExtractor implements ResultSetExtractor<Map<CoinEnum, Coin>>{

		@Override
		public Map<CoinEnum, Coin> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<CoinEnum, Coin> coinMap = new HashMap<>();
			while (rs.next()) {
				Coin coin = new Coin();
				coin.setId(rs.getInt("id"));
				coin.setName(rs.getString("name"));
				coin.setCount(rs.getInt("count"));
				coinMap.put(CoinEnum.valueOf(coin.getName()), coin);
			}
			
			return coinMap;
		}
		
	}
	
}
