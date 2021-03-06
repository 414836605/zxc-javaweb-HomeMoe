package ssoft.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ssoft.domain.GroupChat;
import ssoft.domain.GroupChatDiary;
import ssoft.domain.Island;
import ssoft.utils.TransactionManager;

public class IslandDaoImpl implements IslandDao {

	@Override
	public Island createIslandByName(String islandName) {
		String sql = "insert into island values(null,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			runner.update(sql,islandName,new Date(System.currentTimeMillis()),0);
			sql = "select * from island where id = (select max(id) from island)";
			return runner.query(sql, new BeanHandler<Island>(Island.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
//		String sql = "insert into groupchat values(null,?,?,null,?,null)";
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		try{
//			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
//		
//			runner.update(sql,groupName,type,sdf.format(new Date(System.currentTimeMillis())));
//			//sql = "SELECT MAX(id) FROM groupchat";
//			sql = "select * from groupchat where id = (select max(id) from groupchat)";
//			return runner.query(sql, new BeanHandler<GroupChat>(GroupChat.class));
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
	}

	@Override
	public Island getIslandByName(String islandName) {
		String sql = "select * from island where name = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanHandler<Island>(Island.class),islandName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> getHotIsland(String start, String offset) {
		String sql = "select * from island where isrecommend = 1 limit ?,? ";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanListHandler<Island>(Island.class),Integer.parseInt(start),Integer.parseInt(offset));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> searchIslandByLikeName(String islandName) {
		String sql = "select * from island where name like ? ";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanListHandler<Island>(Island.class),"%"+islandName+"%");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Island getIslandById(String id) {
		String sql = "select * from island where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanHandler<Island>(Island.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> getAllIsland() {
		String sql = "select * from island";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanListHandler<Island>(Island.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> getIslandAndPaging(int start, int offset) {
		String sql = "select * from island limit ?, ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql,new BeanListHandler<Island>(Island.class), start, offset);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int recommendIsland(String id) {
		String sql = "update island set isrecommend=1 where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.update(sql, id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int cancelRecommendIsland(String id) {
		String sql = "update island set isrecommend=0 where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.update(sql, id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> getRecommendIsland() {
		String sql = "select * from island where isrecommend = 1";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		
			return runner.query(sql,new BeanListHandler<Island>(Island.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Island> getRecommendIslandAndPaging(int start, int offset) {
		String sql = "select * from island where isrecommend = 1 limit ?, ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql,new BeanListHandler<Island>(Island.class), start, offset);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
