package it.javavault.springMVC.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersMapper {
	/**
	 * Returns a list of users
	 * 
	 * @return List<Map>
	 */
	@Select("SELECT * FROM users")
	List<Map<String, Object>> getUserList();

	/**
	 * Returns an user detail from USERID
	 * 
	 * @param userid
	 * @return Map
	 */
	@Select("SELECT * FROM users WHERE userid = #{userid}")
	Map<String, Object> getUserById(@Param("userid") String userid);

	/**
	 * Returns an user detail from USERID
	 * 
	 * @param params
	 *            - Map (USERID , USERNAME , NICKNAME)
	 * @return Map
	 */
	Map<String, Object> getUserDetailById(Map<String, Object> params);

	/**
	 * update user Details by USERID
	 * 
	 * @param Map<String,
	 *            Object>
	 * @return 1 if success
	 */
	int updateUserDetailsById(Map<String, Object> params);

	/**
	 * update user Email by USERID
	 * 
	 * @param userid
	 * @return 1 if success
	 */
	@Update("UPDATE users SET EMAIL = #{email} WHERE USERID = #{userid}")
	int updateUserEmailById(@Param("userid") String userid, @Param("email") String email);

	/**
	 * delete user by USERID
	 * 
	 * @param userid
	 * @return 1 if success
	 */
	@Delete("DELETE FROM users WHERE USERID = #{userid}")
	int deleteUserById(@Param("userid") String userid);

}
