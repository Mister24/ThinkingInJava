/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.jwt;

import com.auth0.jwt.interfaces.Claim;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mr.24
 * @version Id: JwtTokenTest, v 1.0 2018/12/10 上午12:37 Exp $$
 */
public class JwtTokenTest {
    public static void main(String[] args) throws Exception {
        String token = JwtDemo.createToken();

        System.out.println("token:" + token);

        Map<String, Claim> map = JwtDemo.verifyToken(token);

        System.out.println(map.get("name").asString());
        System.out.println(map.get("age").asString());
        System.out.println(map.get("company").asString());
    }
}
