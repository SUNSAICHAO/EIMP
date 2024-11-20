import Bean.User;
import Dao.DaoImpl.UserDaoImpl;
import java.sql.SQLException;

public class JDBCdemo {
    public static void main(String[] args) throws SQLException {
        User user=new User("adm","admin");
        UserDaoImpl userDao=new UserDaoImpl();
        boolean flag = userDao.findUser(user);
        if (flag){
            System.out.println("恭喜您，登陆成功");
        }
        else {
            System.out.println("该用户不存在，请您注册");
        }


    }
}
