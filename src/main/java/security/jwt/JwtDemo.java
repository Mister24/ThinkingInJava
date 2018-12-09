/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt由三部分组成：header、payload、signature
 *
 * 一、header包含2部分信息：类型和加密算法
         * {"type":"JWT","alg":"HS256"}
 * 然后将header进行base64加密，得到jwt的第一部分：eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ==
 *
 * 二、payload包含3部分信息：标准中注册的声明、公共的声明、私有的声明
         * 标准中注册的声明包含:
         *  iss: jwt签发者
         *  sub: jwt所面向的用户
         *  aud: 接收jwt的一方
         *  exp: jwt的过期时间，这个过期时间必须要大于签发时间
         *  nbf: 定义在什么时间之前，该jwt都是不可用的.
         *  iat: jwt的签发时间
         *  jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
         * 公共的声明包含：
         *  公共的声明可以添加任何的信息，一般添加用户的相关信息或其他业务需要的必要信息.但不建议添加敏感信息，因为该部分在客户端可解密。
         * 私有的声明包含：
         *  私有声明是提供者和消费者所共同定义的声明，一般不建议存放敏感信息，因为base64是对称解密的，意味着该部分信息可以归类为明文信息，例如
         *      {"name":"mr.24","age":"24","company":"antFin"}
 * 然后将其进行base64加密，得到jwt的第二部分：eyJuYW1lIjoibXIuMjQiLCJhZ2UiOiIyNCIsImNvbXBhbnkiOiJhbnRGaW4ifQ==
 *
 * 三、signature包含3部分信息：base64处理过的header、base64处理过的payload、secret。
 *
 *
 * @author mr.24
 * @version Id: JwtDemo, v 1.0 2018/12/9 下午11:46 Exp $$
 */
public class JwtDemo {
    /** token密钥 */
    private static final String SECRET_STRING          = "ihcfrehfoe";

    /** token过期时间 */
    private static final int EXPIRE_TIME               = Calendar.DATE;

    /**  */
    private static final int INTERVAL_TIME             = 100000;

    /** 算法 */
    private static final String ALGORITHM              = "HS256";

    /** token类型 */
    private static final String TOKEN_TYPE             = "JWT";

    private static final String HEADER_TOKEN_ALGORITHM = "alg";

    private static final String HEADER_TOKEN_TYPE      = "type";

//    /** jwt签发者 */
//    private static final String PAYLOAD_ISS            = "iss";
//
//    /** jwt面向的用户 */
//    private static final String PAYLOAD_SUB            = "sub";
//
//    /** 接收jwt的一方 */
//    private static final String PAYLOAD_AUD            = "aud";
//
//    /** jwt过期时间，该时间必须大于签发时间 */
//    private static final String PAYLOAD_EXP            = "exp";
//
//    /** 定义jwt开始生效的时间 */
//    private static final String PAYLOAD_NBF            = "nbf";
//
//    /** jwt的唯一身份标识，作为一次性token，避免重放攻击 */
//    private static final String PAYLOAD_JTI            = "nbf";

    /**
     * 构造token
     *
     * @return token
     * */
    public static String createToken() throws Exception {

        // 签发时间
        Date iatDate = new Date();

        // 过期时间
        Calendar currentTime = Calendar.getInstance();
        currentTime.add(EXPIRE_TIME, INTERVAL_TIME);
        Date expireDate = currentTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put(HEADER_TOKEN_ALGORITHM, ALGORITHM);
        map.put(HEADER_TOKEN_TYPE, TOKEN_TYPE);

        String jwtToken = JWT.create().withHeader(map)
                .withClaim("name", "mr.24")
                .withClaim("age", "24")
                .withClaim("company", "antFin")
                .withIssuedAt(iatDate)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET_STRING));

        return jwtToken;
    }

    /**
     * 验证token
     *
     * @param token 收到token值
     *
     * @return      payload中的参数值
     * */
    public static Map<String, Claim> verifyToken(String token) throws Exception {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_STRING))
                .build();
        DecodedJWT decodedJWT = null;

        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("jwt验证无法通过，请重试");
        }

        return decodedJWT.getClaims();
    }
}
