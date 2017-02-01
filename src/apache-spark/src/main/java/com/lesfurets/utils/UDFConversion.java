package com.lesfurets.utils;

import com.lesfurets.domain.FormuleMapper;

import java.io.Serializable;
import java.util.function.Function;

public interface UDFConversion {

    Function<Integer, String> readableFormule = (Serializable & Function<Integer, String>) FormuleMapper::asString;

}
