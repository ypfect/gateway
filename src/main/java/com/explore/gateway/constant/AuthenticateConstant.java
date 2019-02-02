package com.explore.gateway.constant;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/1/31 16:26
 */
public interface AuthenticateConstant {

    String BEARER_TOKEN_TYPE = "bearer ";

    String Authorization = "Authorization";

    String USER_ID = "user-header-id";

    String USER_ROLES = "user-header-roles";

    String SECRET = "mySecret";

    String GOODS_OPEN_API_A = "/goods/sku/user";

    String GOODS_OPEN_API_B = "/goods/GoodsClassificationFront/user";

}
