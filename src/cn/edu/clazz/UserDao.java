package cn.edu.clazz;

public class UserDao extends BaseDao<User>{
	public static void main(String[] args) {
		Class uclazz = User.class;
		System.out.println(uclazz.getConstructors().length);
	}
}
