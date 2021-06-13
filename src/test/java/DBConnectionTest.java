import org.example.Connect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DBConnectionTest {

        @Test
    public void getDBConnection_throwables_printStackTrace(){
            //given
            String jdbc ="jdbc:oracle:thin:@localhost:1521:ORCL";
            String userid = "humba";
            String password = "12345";
            Connect service = new Connect();

            //when



            //then
            Assertions.assertThrows(SQLException.class,()->service.getDBConnection(jdbc,userid,password));

    }


}
