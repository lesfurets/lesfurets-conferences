package com.lesfurets.udf;

import com.lesfurets.domain.ProductMapper;

import java.io.Serializable;
import java.util.function.Function;

public interface UDFConversion {

    Function<Integer, String> readableProduct = (Serializable & Function<Integer, String>) ProductMapper::french;

}
