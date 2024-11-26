package org.aey.user.infrastructure.persistence.queries;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class UserQueryManager {

    //User constrains
    public static final Integer USER_ID_LEN = 21;
    //User columns names
    public static final String USER_TABLE_NAME = "t_usr01_users";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "usr_tx_name";
    public static final String USER_FIRST_NAME = "usr_tx_first_surname";
    public static final String USER_SECOND_SURNAME = "usr_tx_second_surname";
    public static final String USER_BIRTHDATE = "usr_dt_birthdate";
    public static final String USER_CREATED_AT = "usr_dt_created_at";
    public static final String USER_UPDATED_AT = "usr_dt_updated_at";
    public static final String USER_IS_ACTIVE = "usr_st_is_active";

    public static  final String PARAM_USER_LIMIT = "limit";
    public static  final String PARAM_USER_OFFSET = "offset";
    public static final String PARAM_USER_EMAIL = "userEmail";
    public static final String PARAM_USER_NICK_NAME = "nickName";

    public static final String  USERS_PAGINATION =
            "select user_id, " +
                    "usr_tx_name as name, " +
                    "usr_tx_first_surname as first_surname, " +
                    "usr_tx_second_surname as second_surname, " +
                    "usr_dt_birthdate as birthdate, " +
                    "usr_dt_created_at as created_at, " +
                    "usr_dt_updated_at as updated_at, " +
                    "usr_st_is_active as is_active " +
                    "from t_usr01_users " +
                    "where usr_st_is_active = true " +
                    "limit :limit " +
                    "offset :offset";

}
