package com.projeto.farmacia.projections;

public interface UserDetailsProjection {

    String getUserName();
    String getPassword();
    Long getRoleId();
    String getAuthority();

}
