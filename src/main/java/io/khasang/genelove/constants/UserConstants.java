package io.khasang.genelove.constants;


public final class UserConstants {
    private UserConstants() {
    }

    public static final class Entity {

        public static final String TABLE_NAME_USER = "users";
        public static final String ID_USER = "id_user";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String ROLE = "role";

        private Entity() {
        }
    }
    public static final class Role {

        public static final String ROLE_USER = "USER";
        public static final String ROLE_MANAGER = "MANAGER";
        public static final String ROLE_ADMINISTRATOR = "ADMINISTRATOR";

        private Role(){}
    }
    }
