package com.digitalinnovation.PessoasAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("home"),
    MOBILE("MOBILE"),
    COMMERCIAL("Commercial");

    private final String description;



}
