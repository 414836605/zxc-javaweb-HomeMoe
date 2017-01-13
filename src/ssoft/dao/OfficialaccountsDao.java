package ssoft.dao;

import java.util.List;

import ssoft.domain.Officialaccounts;
import ssoft.domain.UserOfficialaccount;

public interface OfficialaccountsDao extends Dao {

	

	/**
	 * 获取公众号
	 * @param officialaccount_id
	 * @return
	 */
	Officialaccounts getOfficialaccountById(int officialaccount_id);

	/**
	 * 添加一条公众号
	 * @param officialaccountName
	 * @param coordinate
	 * @param type
	 * @return
	 */
	Officialaccounts createOfficialaccount(String officialaccountName,
			String coordinate, String type);

	/**
	 * 获取所有的公众号
	 * @return
	 */
	List<Officialaccounts> getAllOfficial();

}
